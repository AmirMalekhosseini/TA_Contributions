import sys

# Increase recursion depth just in case, though we rely on iterative logic
sys.setrecursionlimit(300000)


def solve():
    # 1. Fast Input Reading (Read all as integers at once)
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # Use an iterator to traverse the flat integer list
    iterator = map(int, input_data)

    try:
        n = next(iterator)
        m = next(iterator)
        q = next(iterator)
    except StopIteration:
        return

    # 2. Parse Graph Edges
    # We store (u, v, weight) in a lookup list for queries
    # We also create a separate list for the main Kruskal's sorting
    edge_lookup = [None] * m
    graph_edges = [None] * m

    for i in range(m):
        u = next(iterator)
        v = next(iterator)
        w = next(iterator)
        edge_lookup[i] = (u, v, w)
        graph_edges[i] = (w, u, v)

    # Sort graph edges by weight
    graph_edges.sort(key=lambda x: x[0])

    # 3. Parse Queries
    # Instead of storing complex structures per query, we flatten everything.
    # query_ops will store tuples: (weight, query_id, u, v)
    # This allows us to sort ALL query requirements by weight efficiently.
    query_ops = []

    # We track the status of each query. Initially True (YES).
    query_status = [True] * q

    for i in range(q):
        k = next(iterator)
        for _ in range(k):
            # Input is 1-based index
            edge_idx = next(iterator) - 1
            u, v, w = edge_lookup[edge_idx]
            query_ops.append((w, i, u, v))

    # Sort query operations: primarily by weight, secondarily by query_id
    # This groups operations by weight, and within weight by query.
    query_ops.sort(key=lambda x: (x[0], x[1]))

    # 4. DSU Structures
    # parent[i] == i means root.
    parent = list(range(n + 1))
    # rank used for Union-by-Rank to keep tree height O(log N)
    rank = [0] * (n + 1)

    # History stack for rollback: (child_node, rank_was_incremented_bool)
    history = []

    # 5. Main Processing Pointers
    g_ptr = 0
    q_ptr = 0
    total_g = m
    total_q = len(query_ops)

    # We process weights in increasing order
    while g_ptr < total_g or q_ptr < total_q:
        # Determine current weight processing step
        w_g = graph_edges[g_ptr][0] if g_ptr < total_g else float('inf')
        w_q = query_ops[q_ptr][0] if q_ptr < total_q else float('inf')

        current_w = w_g if w_g < w_q else w_q

        # Phase 1: Process Queries at this weight
        # We look ahead in query_ops to find all ops with weight == current_w
        while q_ptr < total_q and query_ops[q_ptr][0] == current_w:
            # We process a batch for a single query_id
            q_id = query_ops[q_ptr][1]

            # If this query is already failed, we skip its edges
            if not query_status[q_id]:
                # Advance pointer past all edges for this specific query at this weight
                while q_ptr < total_q and query_ops[q_ptr][0] == current_w and query_ops[q_ptr][1] == q_id:
                    q_ptr += 1
                continue

            # Snapshot history size for rollback
            history_start_len = len(history)

            # Process all edges for this query at this weight
            while q_ptr < total_q and query_ops[q_ptr][0] == current_w and query_ops[q_ptr][1] == q_id:
                _, _, u, v = query_ops[q_ptr]
                q_ptr += 1

                # --- INLINED FIND ---
                root_u = u
                while root_u != parent[root_u]:
                    root_u = parent[root_u]

                root_v = v
                while root_v != parent[root_v]:
                    root_v = parent[root_v]
                # --------------------

                if root_u != root_v:
                    # --- INLINED UNION (Record history) ---
                    if rank[root_u] < rank[root_v]:
                        root_u, root_v = root_v, root_u

                    parent[root_v] = root_u

                    rank_changed = False
                    if rank[root_u] == rank[root_v]:
                        rank[root_u] += 1
                        rank_changed = True

                    history.append((root_v, rank_changed))
                    # --------------------------------------
                else:
                    # Cycle detected -> Query Fails
                    query_status[q_id] = False
                    # We don't break immediately because we must parse through the rest of this query's edges
                    # in the list to correct the q_ptr, but we stop doing Unions.

            # Rollback DSU to state before this query
            while len(history) > history_start_len:
                child, rank_changed = history.pop()
                p = parent[child]  # Parent of child
                parent[child] = child  # Reset parent
                if rank_changed:
                    rank[p] -= 1

        # Phase 2: Process Graph Edges at this weight (Permanent)
        while g_ptr < total_g and graph_edges[g_ptr][0] == current_w:
            _, u, v = graph_edges[g_ptr]
            g_ptr += 1

            # --- INLINED FIND ---
            root_u = u
            while root_u != parent[root_u]:
                root_u = parent[root_u]

            root_v = v
            while root_v != parent[root_v]:
                root_v = parent[root_v]
            # --------------------

            if root_u != root_v:
                # --- INLINED UNION (No history needed) ---
                if rank[root_u] < rank[root_v]:
                    root_u, root_v = root_v, root_u
                parent[root_v] = root_u
                if rank[root_u] == rank[root_v]:
                    rank[root_u] += 1
                # -----------------------------------------

    # Output results
    output = []
    for s in query_status:
        output.append("YES" if s else "NO")
    sys.stdout.write('\n'.join(output) + '\n')


if __name__ == '__main__':
    solve()

import sys

# Increase recursion depth for deep graphs
sys.setrecursionlimit(200000)


def solve():
    # Fast I/O
    input = sys.stdin.read
    data = input().split()
    iterator = iter(data)

    try:
        n = int(next(iterator))
        m = int(next(iterator))
    except StopIteration:
        return

    # Adjacency lists: forward (g) and reverse (rg)
    g = [[] for _ in range(n + 1)]
    rg = [[] for _ in range(n + 1)]

    for _ in range(m):
        u = int(next(iterator))
        v = int(next(iterator))
        g[u].append(v)
        rg[v].append(u)

    # --- Lengauer-Tarjan Algorithm Setup ---

    # par: parent in DFS tree
    par = [0] * (n + 1)
    # semi: semi-dominator (initially self)
    semi = list(range(n + 1))
    # dfn: discovery time (DFS number)
    dfn = [0] * (n + 1)
    # rev_dfn: map time -> node
    rev_dfn = [0] * (n + 1)
    # idom: immediate dominator
    idom = [0] * (n + 1)

    # Union-Find / DSU structures
    # best: node with min semi-dominator in the path to root
    best = list(range(n + 1))
    # dsu_par: parent in DSU structure
    dsu_par = list(range(n + 1))

    count = 0

    # 1. DFS to set up traversal order and parents
    def dfs(u):
        nonlocal count
        count += 1
        dfn[u] = count
        rev_dfn[count] = u
        for v in g[u]:
            if dfn[v] == 0:
                par[v] = u
                dfs(v)

    dfs(1)

    # DSU Find with Path Compression keeping track of 'best' (min semi)
    def find(x):
        if dsu_par[x] == x:
            return x
        root = find(dsu_par[x])
        # If the 'best' of my parent has a lower semi than my current 'best', update mine
        if dfn[semi[best[dsu_par[x]]]] < dfn[semi[best[x]]]:
            best[x] = best[dsu_par[x]]
        dsu_par[x] = root
        return root

    # Bucket to hold nodes waiting for semi-dominator processing
    bucket = [[] for _ in range(n + 1)]

    # 2. Iterate in reverse DFS order
    for i in range(count, 1, -1):
        u = rev_dfn[i]

        # Process predecessors to find semi-dominator
        for v in rg[u]:
            if dfn[v] == 0:
                continue  # Skip unreachable nodes

            find(v)  # Compress path

            # The candidate semi is the semi of the 'best' node in the branch
            candidate = semi[best[v]]
            if dfn[candidate] < dfn[semi[u]]:
                semi[u] = candidate

        # Add u to the bucket of its semi-dominator
        bucket[semi[u]].append(u)

        # Link in DSU
        dsu_par[u] = par[u]

        # Process the bucket of the parent (now that we are moving up)
        parent_u = par[u]
        for v in bucket[parent_u]:
            find(v)
            # If semi[v] is the same as semi[best[v]], then idom is parent
            # Otherwise, idom is idom[best[v]] (resolve later)
            if semi[best[v]] == semi[v]:
                idom[v] = semi[v]
            else:
                idom[v] = best[v]
        bucket[parent_u] = []  # Clear bucket

    # 3. Final pass to resolve immediate dominators
    for i in range(2, count + 1):
        u = rev_dfn[i]
        if idom[u] != semi[u]:
            idom[u] = idom[idom[u]]

    # 4. Collect Critical Cities
    # Start from N and move up the dominator tree until we hit 1
    ans = []
    curr = n

    # Note: If n is not reachable, dfn[n] will be 0.
    # But problem guarantees a route exists.
    while curr != 0:
        ans.append(curr)
        if curr == 1:
            break
        curr = idom[curr]

    ans.sort()

    print(len(ans))
    print(*(ans))


if __name__ == '__main__':
    solve()

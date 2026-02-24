import sys

# Increase recursion depth for deep trees (lines)
sys.setrecursionlimit(200000)


def solve():
    # Use fast I/O
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    iterator = iter(input_data)
    n = int(next(iterator))

    # Adjacency list
    adj = [[] for _ in range(n + 1)]

    # Reading n-1 edges
    for _ in range(n - 1):
        u = int(next(iterator))
        v = int(next(iterator))
        adj[u].append(v)
        adj[v].append(u)

    # Identify leaves using DFS traversal order
    leaves = []

    def dfs(u, p):
        # If degree is 1, it's a leaf.
        # Note: Root is a leaf if degree is 1, non-roots are leaves if degree is 1.
        # However, checking len(adj[u]) == 1 is valid for ALL nodes
        # because the input is a valid tree with N >= 3.
        # (For N=2, both are leaves, logic still holds).
        if len(adj[u]) == 1:
            leaves.append(u)

        for v in adj[u]:
            if v != p:
                dfs(v, u)

    # Start DFS from node 1 (or any node with degree > 1 if specific rooting is needed,
    # but 1 is fine for coverage).
    dfs(1, -1)

    k = len(leaves)

    # Minimum edges needed is ceil(K / 2)
    # Equivalent to (K + 1) // 2
    needed_edges = (k + 1) // 2
    print(needed_edges)

    # Pairing Strategy:
    # We pair index `i` with index `i + k/2`
    # This "crosses" the tree, connecting left-side leaves to right-side leaves.
    mid = k // 2

    for i in range(mid):
        print(f"{leaves[i]} {leaves[i + mid]}")

    # If there was an odd number of leaves, one is left over (the last one).
    # We connect the last leaf to the first leaf to ensure it's part of a cycle.
    if k % 2 == 1:
        print(f"{leaves[k-1]} {leaves[0]}")


if __name__ == '__main__':
    solve()

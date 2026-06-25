class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges)!= n-1:
            return False

        adj_list = defaultdict(list)
        for u, v in edges:
            adj_list[u].append(v)
            adj_list[v].append(u)
        
        total = 0
        def dfs(node, visited, adj_list, parent):
            nonlocal total
            total+=1
            if node in visited:
                return False
            visited.add(node)
            for neighbor in adj_list[node]:
                if neighbor!=parent:
                    if not dfs(neighbor, visited, adj_list, node):
                        return False
            return True
        
        return dfs(0,set(), adj_list, -1) and total==n
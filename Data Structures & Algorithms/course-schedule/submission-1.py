class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegree = [0] * numCourses
        adj_list =defaultdict(list)
        for dest, src in prerequisites:
            indegree[dest]=indegree[dest] + 1
            adj_list[src].append(dest)
        queue  = deque([u for u in range(numCourses) if indegree[u]==0])
        
        total = []
        while queue:
            curr = queue.popleft()
            total.append(curr)
            for neighbor in adj_list[curr]:
                indegree[neighbor]-=1
                if indegree[neighbor]==0:
                    queue.append(neighbor)
        return len(total) == numCourses

class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        graph: list[dict[int, list[int]]] = [defaultdict(list) for _ in range(len(online))]
        # graph[u][v] = [w1, w2] means there is an edge from u to v with weight w1 and another one with weight w2.
        in_degrees: list[int] = [0] * len(online)
        for u, v, w in edges:
            if online[u] and online[v]:
                graph[u][v].append(w)
                in_degrees[v] += 1
        
        queue: deque[int] = deque()
        for node in range(len(online)):
            if in_degrees[node] == 0 and online[node]:
                queue.appendleft(node)
        
        topological_order: list[int] = []
        while queue:
            node = queue.pop()
            topological_order.append(node)
            for neighbour in graph[node]:
                in_degrees[neighbour] -= len(graph[node][neighbour])
                if in_degrees[neighbour] == 0:
                    queue.appendleft(neighbour)
        
        low: int = -1
        high: int = k
        while low < high:
            mid: int = (low + high + 1) // 2
            if self.can_reach_end_with_score_of_mid(
                graph, topological_order, mid, k
            ):
                low = mid
            else:
                high = mid - 1
    
        return low
    
    def can_reach_end_with_score_of_mid(
            self,
            graph: list[dict[int, list[int]]],
            topological_order: list[int],
            mid: int,
            k: int
    ) -> bool:
        min_distances: list[int] = [10**21] * len(graph)
        min_distances[0] = 0
        
        for node in topological_order:
            if node == len(graph) - 1:
                return min_distances[node] <= k
            if min_distances[node] > k:
                continue
            for neighbour in graph[node]:
                for edge in graph[node][neighbour]:
                    if edge >= mid:
                        min_distances[neighbour] = min(
                            min_distances[neighbour],
                            min_distances[node] + edge
                        )
        
        raise ValueError("Should not reach here") 
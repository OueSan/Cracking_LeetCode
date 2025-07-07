import bisect
from collections import defaultdict

class MajorityChecker:

    def __init__(self, arr: list[int]):
        self.arr = arr
        self.n = len(arr)
        self.pos_map = defaultdict(list)
        for i, v in enumerate(arr):
            self.pos_map[v].append(i)
        self.tree = [ (None, 0) ] * (4 * self.n)
        self._build_tree(1, 0, self.n - 1)
    
    def _merge_pair(self, left_pair: tuple[int,int], right_pair: tuple[int,int]) -> tuple[int,int]:
        """
            Merge two Boyer–Moore pairs (cand1, cnt1) and (cand2, cnt2) as if we ran majority-vote on the concatenation of their two segments.
        """
        cand1, cnt1 = left_pair
        cand2, cnt2 = right_pair

        if cand1 is None:
            return (cand2, cnt2)
        if cand2 is None:
            return (cand1, cnt1)

        if cand1 == cand2:
            return (cand1, cnt1 + cnt2)
        else:
            if cnt1 > cnt2:
                return (cand1, cnt1 - cnt2)
            elif cnt2 > cnt1:
                return (cand2, cnt2 - cnt1)
            else:
                return (None, 0)

    def _build_tree(self, node: int, start: int, end: int) -> None:
        """
        Recursively build the segment tree in self.tree[node].
        Each leaf stores (arr[i], 1).  Internal nodes merge their children.
        """
        if start == end:
            v = self.arr[start]
            self.tree[node] = (v, 1)
        else:
            mid = (start + end) // 2
            left_node = 2 * node
            right_node = 2 * node + 1

            self._build_tree(left_node, start, mid)
            self._build_tree(right_node, mid + 1, end)
            self.tree[node] = self._merge_pair(self.tree[left_node], self.tree[right_node])

    def _query_tree(self, node: int, start: int, end: int,
                    L: int, R: int) -> tuple[int,int]:
        """
        Return the Boyer–Moore pair (candidate, net_count) for the subrange [L..R].
        If [start..end] is completely outside [L..R], return (None, 0).
        If it is fully inside, return self.tree[node].
        Otherwise, split to children.
        """
        if R < start or end < L:
            # Completely outside
            return (None, 0)
        if L <= start and end <= R:
            # Completely inside
            return self.tree[node]
        mid = (start + end) // 2
        left_pair = self._query_tree(2 * node, start, mid, L, R)
        right_pair = self._query_tree(2 * node + 1, mid + 1, end, L, R)
        return self._merge_pair(left_pair, right_pair)
    
    def query(self, left: int, right: int, threshold: int) -> int:
        cand, _ = self._query_tree(1, 0, self.n - 1, left, right)
        if cand is None:
            return -1
        idx_list = self.pos_map[cand]
        lo = bisect.bisect_left(idx_list, left)
        hi = bisect.bisect_right(idx_list, right)
        actual_count = hi - lo

        return cand if actual_count >= threshold else -1

# Your MajorityChecker object will be instantiated and called as such:
# obj = MajorityChecker(arr)
# param_1 = obj.query(left,right,threshold)
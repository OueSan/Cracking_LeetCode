class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        s, up = set(nums), pow(2, 31) - 1
        nums_sorted = [up - x for x in s]
        nums_sorted.sort()
        n = len(nums_sorted) + 1
        D = {x : i for i, x in enumerate(nums_sorted)}
        def update(x):
            index = 1 + D[x]
            while index < n:
                tree[index] += 1
                index += index & -index
        def query(index):
            res = 0
            while index >= 1:
                res += tree[index]
                index -= index & -index
            return res
        ans, tree = 0, [0] * n
        for x in nums:
            index = bisect_left(nums_sorted, up - 2 * x)
            ans += query(index)
            update(up - x)
        return ans




        
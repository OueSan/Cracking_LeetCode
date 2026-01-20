class Solution:
    def minOperations(self, p: List[int], l: List[int]) -> int:
        mp = {v: i for i, v in enumerate(p)}
        lis = [-1]
        for v in l:
            i = mp.get(v)
            if i is None: continue
            if lis[-1] < i:
                lis.append(i)
            else:
                lis[bisect_left(lis, i)] = i
        return len(p) - len(lis) + 1
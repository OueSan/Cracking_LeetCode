class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        s = set(bobSizes)
        diff = sum(bobSizes) - sum(aliceSizes)

        for x in aliceSizes:
            if (diff + 2 * x) // 2 in s:
                return [x, (diff + 2 * x) / 2]
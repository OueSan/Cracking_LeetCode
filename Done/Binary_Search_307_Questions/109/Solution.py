class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        prefix = [0]
        for x in nums: prefix.append(prefix[-1] + x)
        
        ans = j = k = 0 
        for i in range(1, len(nums)): 
            j = max(j, i+1)
            while j < len(nums) and 2*prefix[i] > prefix[j]: j += 1
            k = max(k, j)
            while k < len(nums) and 2*prefix[k] <= prefix[i] + prefix[-1]: k += 1
            ans += k - j 
        return ans % 1_000_000_007
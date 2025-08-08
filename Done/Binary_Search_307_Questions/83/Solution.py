class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        l=1
        r=max(nums)
        def calculate(mid,nums,threshold):
            res=0
            for i in range(len(nums)):
                res+=math.ceil(nums[i]/mid)
            if res<=threshold:
                return True
            else:
                return False
        while l<=r:
            mid=(l+r)//2
            if calculate(mid,nums,threshold):
                r=mid-1
            else:
                l=mid+1
        return l
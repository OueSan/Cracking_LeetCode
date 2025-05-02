class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        i, j = 1, len(arr)-2
        while i < j:
            mid = (i+j+1)//2
            if arr[mid] > arr[mid-1]:
                i = mid
            else:
                j = mid - 1
        return i
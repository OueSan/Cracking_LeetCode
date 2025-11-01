class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        l = 0
        h = len(arr)
        while h > l:
            mid = (h+l)//2
            miss = arr[mid]-mid-1
            if k <= miss:
                h = mid
            else:
                 l = mid+1
        
        return k + l
from sortedcontainers import SortedList
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        output = []
        s = SortedList()
        for num in nums[::-1]:
            i = SortedList.bisect_left(s, num)
            s.add(num)
            output.append(i)
        return output[::-1]
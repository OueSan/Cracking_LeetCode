class Solution:
    def findNthDigit(self, n: int) -> int:
        digit_in_num = 1
        start = 1
        end = 9

        while n > digit_in_num * end:
            n -= digit_in_num * end
            digit_in_num += 1
            start *= 10
            end *= 10

        num = start + (n - 1) // digit_in_num
        return int(str(num)[(n - 1) % digit_in_num])
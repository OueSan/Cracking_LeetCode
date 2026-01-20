class Solution:
    def maxMatrixSum(self, a: List[List[int]]) -> int:
        pos_sum = 0
        
        num_neg = 0
        least_abs = inf

        for row in a:
            for x in row:
                if x < 0:
                    num_neg += 1
                    x = -x

                if x < least_abs:
                    least_abs = x
                
                pos_sum += x
        
        if num_neg % 2 == 0:
            return pos_sum
        else:
            return pos_sum - least_abs * 2
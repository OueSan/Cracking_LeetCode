class Solution:
    def minimumBoxes(self, n: int) -> int:
        x = int((6*n)**(1/3))
        if x*(x+1)*(x+2) > 6*n: x -= 1
        n -= x*(x+1)*(x+2)//6
        return x*(x+1)//2 + ceil((sqrt(1+8*n)-1)/2)
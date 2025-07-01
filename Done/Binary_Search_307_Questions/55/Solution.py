class Solution:
    def reachNumber(self, target: int) -> int:
        t=abs(target)
        n=math.floor(math.sqrt(2*t))
        while True:
            to_minus=((n+1)*n)/2-t
            if to_minus>=0:
                if to_minus%2==0:
                    return int(n)
            n+=1
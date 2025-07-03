class TimeMap:

    def __init__(self):
        self.dict = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.dict[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.dict:
            return ""
        
        if timestamp >= self.dict[key][-1][1]:
            return self.dict[key][-1][0]
        
        l = 0 
        r = len(self.dict[key]) - 1

        while l <= r:
            m = (l + r) // 2
            if self.dict[key][m][1] < timestamp:
                l = m + 1
            elif self.dict[key][m][1] > timestamp:
                r = m - 1
            else:
                return self.dict[key][m][0]
        if r < 0:
            return ""
        else:
            return self.dict[key][r][0]


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
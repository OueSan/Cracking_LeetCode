class SummaryRanges:

    def __init__(self):
        self.intervals = []

    def addNum(self, value: int) -> None:
        i = 0
        while i < len(self.intervals):
            if self.intervals[i][1] < value - 1:
                i += 1
            else:
                if self.intervals[i][1] == value - 1:
                    if i + 1 < len(self.intervals) and self.intervals[i + 1][0] == value + 1:
                        self.intervals[i][1] = self.intervals[i + 1][1]
                        self.intervals.pop(i + 1)
                    else:
                        self.intervals[i][1] = value
                elif self.intervals[i][0] == value + 1:
                    self.intervals[i][0] = value
                elif self.intervals[i][0] > value + 1:
                    self.intervals.insert(i, [value, value])
                break
        if i == len(self.intervals):
            self.intervals.append([value, value])



    def getIntervals(self) -> List[List[int]]:
        return self.intervals
        


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()
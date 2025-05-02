class Solution:

    def __init__(self, w: List[int]):
        self.running_sums = []
        running_sum = 0

        for weight in w:
            running_sum += weight
            self.running_sums.append(running_sum)

        self.total_sum = running_sum

    def pickIndex(self) -> int:
        target = random.randint(1, self.total_sum)
        low, high = 0, len(self.running_sums)

        while low < high:
            mid = low + (high - low) // 2
            if target > self.running_sums[mid]:
                low = mid + 1
            else:
                high = mid

        return low
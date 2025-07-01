class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()

        j = 0
        max_rad = 0
        for i in range(len(houses)):
            rad = abs(houses[i] - heaters[j])
           
            while j < len(heaters) - 1:
                next_rad = abs(houses[i] - heaters[j + 1])
                if next_rad <= rad:
                    j += 1
                    rad = next_rad
                else:
                    break
            
            max_rad = max(max_rad, rad)

        return max_rad
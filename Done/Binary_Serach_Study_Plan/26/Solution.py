import bisect
class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        n = len(potions)
        pairs = []
        for spell in spells:
            minPower = (success + spell - 1) // spell
            index = bisect.bisect_left(potions, minPower)
            pairs.append(n - index)      
        
        return pairs        
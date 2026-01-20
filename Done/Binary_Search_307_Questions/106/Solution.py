from typing import List

class SegmentTree:
    def __init__(self, nums):
        self.root = self._build(nums, 0, len(nums) - 1)
    
    def _build(self, nums, l, r):
        node = {'l': l, 'r': r, 'sum': 0, 'lChild': None, 'rChild': None}
        
        if l == r:
            node['sum'] = nums[l]
            return node
        
        mid = (l + r) // 2
        node['lChild'] = self._build(nums, l, mid)
        node['rChild'] = self._build(nums, mid + 1, r)
        node['sum'] = node['lChild']['sum'] + node['rChild']['sum']
        
        return node
    
    def update(self, index, val):
        self._point_update(self.root, index, val)
    
    def _point_update(self, node, index, value):
        if node['l'] == node['r']:
            node['sum'] = value
            return
        
        mid = (node['l'] + node['r']) // 2
        if index <= mid:
            self._point_update(node['lChild'], index, value)
        else:
            self._point_update(node['rChild'], index, value)
        node['sum'] = node['lChild']['sum'] + node['rChild']['sum']
    
    def range_query(self, left, right):
        return self._range_query(self.root, left, right)
    
    def _range_query(self, node, l, r):
        if l > node['r'] or r < node['l']:
            return 0
        
        if l <= node['l'] and r >= node['r']:
            return node['sum']
        
        return self._range_query(node['lChild'], l, r) + self._range_query(node['rChild'], l, r)

def valueToIndexMap(input_list):
    unique_values = sorted(set(input_list))
    mapping = {}
    for index, value in enumerate(unique_values):
        mapping[value] = index
    return mapping

class Solution:
    def createSortedArray(self, instructions: List[int]) -> int:
        MOD = 10**9 + 7
        
        mapping = valueToIndexMap(instructions)
        n = len(mapping)
        counts = [0] * n
        st = SegmentTree(counts)
        
        total_cost = 0
        
        for instruction in instructions:
            idx = mapping[instruction]
            
            less_count = st.range_query(0, idx - 1) if idx > 0 else 0
            greater_count = st.range_query(idx + 1, n - 1) if idx < n - 1 else 0
            
            total_cost = (total_cost + min(less_count, greater_count)) % MOD
            
            counts[idx] += 1
            st.update(idx, counts[idx])
        
        return total_cost
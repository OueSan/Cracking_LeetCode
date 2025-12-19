import java.util.*;

class SegmentTree {
    private class Node {
        int l, r;
        int sum;
        Node lChild;
        Node rChild;
        
        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.sum = 0;
            this.lChild = null;
            this.rChild = null;
        }
    }
    
    private Node root;
    
    public SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    private Node build(int[] nums, int l, int r) {
        Node node = new Node(l, r);
        
        if (l == r) {
            node.sum = nums[l];
            return node;
        }
        
        int mid = (l + r) / 2;
        node.lChild = build(nums, l, mid);
        node.rChild = build(nums, mid + 1, r);
        node.sum = node.lChild.sum + node.rChild.sum;
        
        return node;
    }
    
    public void update(int index, int val) {
        pointUpdate(root, index, val);
    }
    
    private void pointUpdate(Node node, int index, int value) {
        if (node.l == node.r) {
            node.sum = value;
            return;
        }
        
        int mid = (node.l + node.r) / 2;
        if (index <= mid) {
            pointUpdate(node.lChild, index, value);
        } else {
            pointUpdate(node.rChild, index, value);
        }
        node.sum = node.lChild.sum + node.rChild.sum;
    }
    
    public int rangeQuery(int left, int right) {
        return rangeQuery(root, left, right);
    }
    
    private int rangeQuery(Node node, int l, int r) {
        if (l > node.r || r < node.l) {
            return 0;
        }
        
        if (l <= node.l && r >= node.r) {
            return node.sum;
        }
        
        return rangeQuery(node.lChild, l, r) + rangeQuery(node.rChild, l, r);
    }
}

class Solution {
    private Map<Integer, Integer> valueToIndexMap(int[] input) {
        Set<Integer> uniqueValues = new TreeSet<>();
        for (int value : input) {
            uniqueValues.add(value);
        }
        Map<Integer, Integer> mapping = new HashMap<>();
        int index = 0;
        for (int value : uniqueValues) {
            mapping.put(value, index++);
        }
        return mapping;
    }
    
    public int createSortedArray(int[] instructions) {
        final int MOD = 1000000007;
        
        Map<Integer, Integer> mapping = valueToIndexMap(instructions);
        int n = mapping.size();
        int[] counts = new int[n];
        SegmentTree st = new SegmentTree(counts);
        
        long totalCost = 0;
        
        for (int instruction : instructions) {
            int idx = mapping.get(instruction);
            
            int lessCount = idx > 0 ? st.rangeQuery(0, idx - 1) : 0;
            int greaterCount = idx < n - 1 ? st.rangeQuery(idx + 1, n - 1) : 0;
            
            totalCost = (totalCost + Math.min(lessCount, greaterCount)) % MOD;
            
            counts[idx]++;
            st.update(idx, counts[idx]);
        }
        
        return (int) totalCost;
    }
}
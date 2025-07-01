// Time Complexity: O(N ^ 2)
// Space Complexity: O(N)
class MyCalendarThree {
    // can I use `ArrayList` instead? 
    // given that the constraints state 0 <= start < end <= 10 ^ 9 
    // it means we need to sweep from 0 to 10 ^ 9 if we use ArrayList
    // let's say the books are [10, 20) and [1e9 - 10, 1e9)
    // then the range [20, 1e9 - 10 - 1] is empty but we still spend time to check them
    
    // in java, we can use TreeMap instead since we only have at most 400 calls
    // in line sweeping, we need to ensure the keys are sorted
    // TreeMap is implemented as red-black trees so the it fulfils
    // lines[i] = j means we have j overlapping elements at time point i
    private TreeMap<Integer, Integer> lines;

    // finding number of overlapping elements at time points -> line sweeping
    
    public MyCalendarThree() {
        // init TreeMap
        lines = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        // new event starts here -> increase by 1
        lines.put(start, lines.getOrDefault(start, 0) + 1);
        // the event ends here -> decrease by 1
        // p.s. sometimes you may see `lines[end + 1]--;`. e.g. 2406. Divide Intervals Into Minimum Number of Groups
        //      you may search `leetcode-the-hard-way` on Discussion to see my solution explanation on that problem
        //      this is because the interval is inclusive, i.e [start, end] 
        //      however, the interval in this problem is [start, end), so we don't need to add 1 here.
        lines.put(end, lines.getOrDefault(end, 0) - 1);
        int mx = 0, cnt = 0;
        for (int x : lines.values()) {
            // here we calculate the prefix sum
            cnt += x;
            // and record the maximum overlapping intervals
            mx = Math.max(mx, cnt);
        }
        return mx;
    }
    
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
class Solution {
public:
    int findNthDigit(int n) {
        string seq;    // To store the sequence
        int i = 1;     // Start from the number 1
        while (seq.length() < n) {  
            seq += to_string(i++);  // Add numbers to the string
        }
        return seq[n - 1] - '0';  // Return the nth digit (adjust for 1-based index)
    }
};
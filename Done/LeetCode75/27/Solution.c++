#include <string>
#include <stack>
using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<pair<string, int>> st;
        string current_string = "";
        int num = 0;

        for (char c : s) {
            if (isdigit(c)) {
                // Build the number for repeat count
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current context to the stack
                st.push({current_string, num});
                current_string = "";
                num = 0;
            } else if (c == ']') {
                // Pop and combine the repeated substring
                auto [last_string, repeat_count] = st.top();
                st.pop();
                string repeated = "";
                for (int i = 0; i < repeat_count; i++) {
                    repeated += current_string;
                }
                current_string = last_string + repeated;
            } else {
                // Append character to the current string
                current_string += c;
            }
        }

        return current_string;
    }
};
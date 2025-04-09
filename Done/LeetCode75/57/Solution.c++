class Solution {
  private:
      // This array maps each digit (2-9) to the corresponding letters on a phone keypad
      vector<string> mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      vector<string> result;
      // Recursive helper function to build combinations
      // `word` stores the current combination being built
      // `digits` is the input string of digits
      // `index` keeps track of the current digit we're processing
      void findword(string word, string& digits, int index) {
          if (index < digits.size()) {
              // Convert current digit character to an integer (e.g., '2' -> 2)
              int i = digits[index] - '0';
              // Loop through each letter mapped to the current digit
              for (char &c : mapping[i]) {
                  // Add the letter to the current word and recurse to the next digit
                  findword(word + c, digits, index + 1);
              }
          } else result.push_back(word);
          // If we've used all digits, store the completed combination
      }
  public:
      vector<string> letterCombinations(string digits) {
          if (digits != "") findword("", digits, 0);
          return result;
      }  
  };
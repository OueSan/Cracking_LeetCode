class SmallestInfiniteSet {
  public:
  
      int current;
      priority_queue<int, vector<int>, greater<int>> minHeap;
      unordered_set<int> addedBack;
  
      // Constructor initializes the set starting from 1
      SmallestInfiniteSet() {
          current = 1;
      }
  
      // Removes and returns the smallest number in the set
      int popSmallest() {
          // If we have added-back numbers, use them first
          if (!minHeap.empty()) {
              int smallest = minHeap.top();    // Get the smallest from heap
              minHeap.pop();                   // Remove it from heap
              addedBack.erase(smallest);       // Also remove from the tracking set
              return smallest;
          }
          // Otherwise, return current and move to the next
          return current++;
      }
  
      // Adds a number back into the set if it's smaller than current
      void addBack(int num) {
          // Only add if it's smaller than current (i.e., already popped)
          // and not already in the minHeap
          if (num < current && addedBack.find(num) == addedBack.end()) {
              minHeap.push(num);       // Push to heap
              addedBack.insert(num);   // Mark it as added
          }
      }
  };
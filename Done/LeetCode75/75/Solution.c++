class Solution {
  public:
      vector<int> dailyTemperatures(vector<int>& temperatures) {
          int n = temperatures.size();
          int highestTemperature = temperatures[n-1];
          vector<int> answer(n, 0);
  
          for(int i = n - 1; i >= 0; i--)
          {
              if (temperatures[i] >= highestTemperature)
              {
                  highestTemperature = temperatures[i];
                  continue;
              }
  
              int nextDays = 1;
              while(temperatures[i] >= temperatures[i + nextDays])
              {
                  nextDays += answer[i + nextDays];
              }
  
              answer[i] = nextDays;
          }
  
          return answer;
      }
  };
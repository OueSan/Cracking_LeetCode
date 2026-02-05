class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        
        int left=0;
        int right=letters.size()-1;

        int ans=0;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(letters[mid]==target){
                left=mid+1;
            }
            else if(letters[mid]>target){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }


        return letters[ans];
    }
};
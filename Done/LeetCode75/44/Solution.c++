class Solution {
  public:
      void dfs(int i,vector<vector<int>>& rooms,int &n,vector<int>&visited){
  
          //if room is already visited then return
          if(visited[i]==-1){
              return;
          }
  
          //otherwise mark current room as visited
          visited[i]=-1;
          
          //if current room contains no key
          if(rooms[i].size()==0){return;}
  
          //unlocking all the keys in current room (i.e ith room)
          for(int j=0;j<rooms[i].size();j++){
  
              //if already visited then return
              if(visited[rooms[i][j]]==-1)continue;
  
              //recursively call for current rooms room with room[i][j] key
              //in this loop i represents current room and j represents the keys present in current room
  
              //dfs call to find keys in jth room
              dfs(rooms[i][j],rooms,n,visited);
          }
          
          return;
      }
  
      bool canVisitAllRooms(vector<vector<int>>& rooms) {
          int n=rooms.size();
          vector<int>visited(n,0);
  
          //dfs for finding keys in first room as this room does not requires key to unlock it 
          dfs(0,rooms,n,visited);
  
          //loop to chrck if all rooms are visited, if not then return false
          for(int i=0;i<visited.size();i++)if(visited[i]==0)return false;
          return true;
      }
  };
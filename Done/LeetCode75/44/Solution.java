class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int count = rooms.size();
      boolean[] unlocked = new boolean[count];
      dfs(rooms, 0, unlocked);
      for( int i = 0 ; i < count ; i++) {
          if(!unlocked[i])
          return false;
      }
      return true;
  }
  public void dfs(List<List<Integer>> rooms, Integer room, boolean[] unlocked) {
      if(unlocked[room])
      return;
      unlocked[room] = true;
      for( Integer key : rooms.get(room)) {
          dfs(rooms, key, unlocked);
      }
  }
}
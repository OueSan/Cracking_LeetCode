class Solution {
  public int equalPairs(int[][] grid) {
      // Create the map, where key is the list of numbers 
      // in this row, value is the occurrence.
      HashMap<List<Integer>,Integer> map = new HashMap<>();
      int res = 0;

      // Loop each row, store the value and occurrence.
      for(int i = 0;i<grid.length;i++){
          List<Integer> arr = new ArrayList<Integer>();
          for(int j = 0;j<grid.length;j++){
              arr.add(grid[i][j]);
          }
          map.put(arr, map.getOrDefault(arr,0)+1);
      }

      // Loop each column
      for(int i = 0;i<grid.length;i++){
          List<Integer> arr = new ArrayList<Integer>();
          for(int j = 0;j<grid.length;j++){
              arr.add(grid[j][i]);
          }

          // if the hashmap contain the same list, 
          // we add the occurrence  to the result.
          if(map.containsKey(arr)){
              res += map.get(arr);
          }
      }

      return res;
  }
}
class Solution {
  public int findCircleNum(int[][] isConnected) {
      // as per question i am using +1 based indexing...
      int v = isConnected.length;

      // If you not comfortable with adj matrix like me then create graph 
      // with the help of adj list/map 
      Map<Integer,List<Integer>> graph = new HashMap<>();
      for(int i = 1 ; i <= v; i++){
          graph.put(i,new ArrayList<>());
      }
      for(int i = 0; i < v; i++){
          for(int j = 0; j < v; j++){
              if(i != j && isConnected[i][j] == 1){
                  graph.get(i+1).add(j+1);
                  graph.get(j+1).add(i+1);
              }
          }
      }

      // one thing that you know Graph is disconnected(Some of them are connected)
      // to go on each starting node you have to create an array of visited array 
      int visited[] = new int[isConnected.length+1];


      // after that i will try to find all possible diconnected component via using visited 
      // array...
      int count = 0;
      for(int i = 1; i < visited.length; i++){
          if(visited[i] == 0){
              count++;
              dfs(graph,visited,i);
          }
      }
      return count;
  }
  public void dfs(Map<Integer,List<Integer>> graph, int []visited,int src){
      Stack<Integer> stack = new Stack<>();
      stack.push(src);
      while(!stack.isEmpty()){
          int v = stack.pop();
          if(visited[v] == 1){
              continue;
          } 
          visited[v] = 1;
          for(int nbrs : graph.get(v)){
              if(visited[nbrs] != 1){
                  stack.push(nbrs);
              }
          }
      }

  }
}
class TreeAncestor {
    private ArrayList<Integer>[] levelGraph; //Tracks nodes at all levels; nodes in a level are 'inOrder' (left->right) 
    private int[] levels, ranks; //levels is 'levelOrder' position of node(multiple nodes can have same level); ranks is 'inOrder' position of node(unique for every node)

    public TreeAncestor(int n, int[] parent) {
        //Make a graph of node and its children
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
        for(int i=1;i<n;i++) graph[parent[i]].add(i);

        //Level-order traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        levels = new int[n];
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int node = q.poll();
                levels[node] = level;
                for(int next: graph[node]) q.add(next);
            }
            level++;
        }

        //In-Order traversal
        ranks = new int[n];
        levelGraph = new ArrayList[level];
        for(int i=0;i<level;i++) levelGraph[i] = new ArrayList<>();
        inOrder(graph, 0, 0);
    }

    private int inOrder(ArrayList<Integer>[] graph, int node, int rank){
        levelGraph[levels[node]].add(node); //add node to levelGraph; note that all existing nodes in levelGraph[levels[node]] will have smaller rank than current node
        ranks[node] = rank; //Assign 'inOrder' position
        for(int next: graph[node]) rank = inOrder(graph, next, ++rank); //For each child from left->right, get the maxRank used by the child subtree, add 1 and assign to next child
        return rank; //max rank used up by subtree rooted at node
    }
    
    public int getKthAncestor(int node, int k) {
        if(node==0) return -1; //0 doesn't have an ancestor
        int level = levels[node];
        if(level<k) return -1; //less than k levels before node's level, i.e., less than k ancestors
        return binarySearch(level-k, ranks[node]); //in the kth ancestor level, search for the highest rank <= rank of node
    }

    private int binarySearch(int level, int target){
        //Basic Binary search
        List<Integer> list = levelGraph[level];
        int lo = 0, hi = list.size()-1, res = lo;
        while(lo<=hi){
            int mid = (lo+hi)/2, node = list.get(mid);
            if(ranks[node]<=target){
                res = node;
                lo = mid+1;
            }
            else
                hi = mid-1;
        }

        return res;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
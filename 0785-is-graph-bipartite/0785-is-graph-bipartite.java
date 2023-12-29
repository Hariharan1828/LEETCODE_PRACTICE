class Solution {
    public boolean isBipartite(int[][] graph) {
        int l = graph.length;
        ArrayList<ArrayList<Integer>> adj 
        = new ArrayList<ArrayList<Integer>>(l);
 
        for (int i = 0; i < l; i++) {
            adj.add(new ArrayList<Integer>());
        }
         
     
        for (int i = 0; i < l; i++) {
            for (int j : graph[i]) {
                adj.get(i).add(j);
                adj.get(j).add(i); // Add this line to handle undirected edges
            }
        }

        int colour[] = new int[graph.length];
        Arrays.fill(colour, -1);

        for(int i=0; i<graph.length;i++){
            if(colour[i]==-1)
                if(dfs(i,0,colour, adj)==false ) return false;
            
        }
        return true;        
        
    }
    public boolean dfs(int node, int col, int colour[], ArrayList<ArrayList<Integer>> adj ){
        colour[node] = col;

        for (int it : adj.get(node)) {
            if (colour[it] == -1) {
                if (!dfs(it, 1 - col, colour, adj)) {
                    return false;
                }
            } else if (colour[it] == col) {
                return false; // Check for bipartiteness condition
            }
        }
        return true;
    }
}
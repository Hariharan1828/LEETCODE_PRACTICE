class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] vis = new int[numCourses];
        for (int[] pre : prerequisites) {
            // Add edge from prerequisite to course
            adj.get(pre[1]).add(pre[0]);
            // Increment in-degree of course
            vis[pre[0]]++;
        }

        // Perform topological sorting using BFS
        Queue<Integer> q = new LinkedList<>();
        // Enqueue courses with in-degree 0 (no prerequisites)
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[numCourses];
        int ind = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topo[ind++]=node;
            // Update in-degrees of dependent courses
            for (int neighbor : adj.get(node)) {
                vis[neighbor]--;
                if (vis[neighbor] == 0) {
                    // Enqueue course if it has no more prerequisites
                    q.add(neighbor);
                }
            }
        }

        // If topological order contains all courses, then it's possible to complete them
        if (ind == numCourses) return topo;
		return new int[0];
        
    }
}
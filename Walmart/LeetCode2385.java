class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int n = 100001;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        dfs(root,adj);
        int visited[] = new int[n];
        visited[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for(int i=0;i<size;i++){
                int node = q.remove();
                for(int j=0;j<adj.get(node).size();j++){
                    if(visited[adj.get(node).get(j)]==0){
                        visited[adj.get(node).get(j)]=1;
                        q.add(adj.get(node).get(j));
                        found = true;
                    }
                }
            }
            if(found){
                count++;
            }
        }
        return count;

    }
    void dfs(TreeNode node,ArrayList<ArrayList<Integer>> adj ){
        if(node.left!=null){
            adj.get(node.val).add(node.left.val);
            adj.get(node.left.val).add(node.val);
            dfs(node.left,adj);
        }
        if(node.right!=null){
            adj.get(node.val).add(node.right.val);
            adj.get(node.right.val).add(node.val);
            dfs(node.right,adj);
        }
    }

}
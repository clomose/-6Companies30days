class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    arr[i][j] = (int)(1e9);
                }
            }
        }
        int len = edges.length;
        for(int i=0;i<len;i++){
            arr[edges[i][0]][edges[i][1]] = edges[i][2];
            arr[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        int num = n;
        int ans = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=num){
                ans = i;
                num = count;
            }
        }
        return ans;
    }
}
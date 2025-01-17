class Solution {
    public int minDays(int[][] arr) {
        int count = island(arr);
        if(count!=1){
            return 0;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    arr[i][j]=0;
                    int c = island(arr);
                    if(c!=1){
                        return 1;
                    }
                    arr[i][j]=1;
                }
            }
        }
        return 2;
    }
    int island(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int count = 0;
        int vis[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && vis[i][j]==0){
                    count++;
                    fill(i,j,arr,vis);
                }
            }
        }
        return count;
    }
    void fill(int r,int c,int[][] arr,int[][] vis){
        vis[r][c]=1;
        if(r+1<arr.length && arr[r+1][c]==1 && vis[r+1][c]==0){
            fill(r+1,c,arr,vis);
        }
        if(c+1<arr[0].length && arr[r][c+1]==1 && vis[r][c+1]==0){
            fill(r,c+1,arr,vis);
        }
        if(r-1>=0 && arr[r-1][c]==1 && vis[r-1][c]==0){
            fill(r-1,c,arr,vis);
        }
        if(c-1>=0 && arr[r][c-1]==1 && vis[r][c-1]==0){
            fill(r,c-1,arr,vis);
        }
    }
}
class Solution {
    public int[][] highestPeak(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int vis[][] = new int[m][n];
        int ans[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    q.add(new Pair(i,j));
                    vis[i][j]=0;
                }else{
                    vis[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            if(row+1<m && vis[row+1][col]==-1){
                vis[row+1][col]=0;
                ans[row+1][col]+=ans[row][col]+1;
                q.add(new Pair(row+1,col));
            }if(col+1<n && vis[row][col+1]==-1){
                vis[row][col+1]=0;
                ans[row][col+1]+=ans[row][col]+1;
                q.add(new Pair(row,col+1));
            }if(row-1>=0 && vis[row-1][col]==-1){
                vis[row-1][col]=0;
                ans[row-1][col]+=ans[row][col]+1;
                q.add(new Pair(row-1,col));
            }if(col-1>=0 && vis[row][col-1]==-1){
                vis[row][col-1]=0;
                ans[row][col-1]+=ans[row][col]+1;
                q.add(new Pair(row,col-1));
            }
        }
        return ans;
    }
}
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
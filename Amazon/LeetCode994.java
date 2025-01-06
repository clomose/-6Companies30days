class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j));
                }
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean f = false;
            for(int i=0;i<size;i++){
                pair p = q.remove();
                int r = p.r;
                int c = p.c;
                if(r-1>=0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    q.add(new pair(r-1,c));
                    f = true;
                }if(c-1>=0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    q.add(new pair(r,c-1));
                    f = true;
                }if(r+1< m && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    q.add(new pair(r+1,c));
                    f = true;
                }if(c+1<n && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    q.add(new pair(r,c+1));
                    f = true;
                }
            }
            if(f){
                count++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count = -1;
                    break;
                }
            }
        }
        return count;
    }
}
class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r = r;
        this.c = c;
    }
}
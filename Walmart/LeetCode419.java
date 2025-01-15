class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][]visited = new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X' && visited[i][j]==0){
                    count++;
                    dfs(i,j,board,visited);
                }
            }
        }
        return count;
    }
    void dfs(int row,int col,char[][] board,int[][] visited){
        visited[row][col]=1;
        if(row-1>=0 && board[row-1][col]=='X' && visited[row-1][col]==0){
            dfs(row-1,col,board,visited);
        }
        if(col-1>=0 && board[row][col-1]=='X' && visited[row][col-1]==0){
            dfs(row,col-1,board,visited);
        }
        if(row+1<board.length && board[row+1][col]=='X' && visited[row+1][col]==0){
            dfs(row+1,col,board,visited);
        }
        if(col+1<board[0].length && board[row][col+1]=='X' && visited[row][col+1]==0){
            dfs(row,col+1,board,visited);
        }
    }
}
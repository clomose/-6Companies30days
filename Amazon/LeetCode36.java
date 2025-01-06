class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num=='.') continue;
                int count = 0;
                //col check;
                for(int k=j+1;k<9;k++){
                    if(board[i][k]==num){
                        count++;
                    }
                }
                //row check
                for(int k=i+1;k<9;k++){
                    if(board[k][j]==num){
                        count++;
                    }
                }
                //sub matrix check
                int row = i-i%3;
                int col = j-j%3;
                for(int k=row;k<row+3;k++){
                    for(int l=col;l<col+3;l++){
                        if(board[k][l]==num){
                            count++;
                        }
                    }
                }
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
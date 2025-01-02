class Solution {
    public int[][] imageSmoother(int[][] img) {
        int [][]ans = new int[img.length][img[0].length];
        for(int row=0;row<img.length;row++){
            for(int col=0;col<img[row].length;col++){
                int sum = img[row][col];
                int count = 1;
                if(col-1>=0){
                    sum+=img[row][col-1];
                    count++;
                }if(col+1<img[row].length){
                    sum+=img[row][col+1];
                    count++;
                }if(row+1<img.length){
                    sum+=img[row+1][col];
                    count++;
                    if(col-1>=0){
                        sum+=img[row+1][col-1];
                        count++; 
                    }if(col+1<img[row].length){
                        sum+=img[row+1][col+1];
                        count++;
                    } 
                }if(row-1>=0){
                    sum+=img[row-1][col];
                    count++;
                    if(col-1>=0){
                        sum+=img[row-1][col-1];
                        count++; 
                    }if(col+1<img[row].length){
                        sum+=img[row-1][col+1];
                        count++;
                    }    
                }
                int val = sum/count;
                ans[row][col] = val;
            }
        }
        return ans;
    }
}
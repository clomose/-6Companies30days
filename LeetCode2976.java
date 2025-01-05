class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long matrix[][] = new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j) continue;
                matrix[i][j] = (long)(1e15);
            }
        }
        for(int i=0;i<original.length;i++){
            matrix[(original[i]-'a')][(changed[i]-'a')]=Math.min( matrix[(original[i]-'a')][(changed[i]-'a')],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    matrix[i][j] = (long)Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        long ans = 0;
        for(int i=0;i<source.length();i++){
            if(matrix[(source.charAt(i)-'a')][(target.charAt(i)-'a')]==(long)1e15){
                return -1;
            }
            ans+=matrix[(source.charAt(i)-'a')][(target.charAt(i)-'a')];
        }
        return ans;
    }
}
class Solution {
    public int numFriendRequests(int[] ages) {
        int []freq = new int[121];
        for(int i : ages){
            freq[i]++;
        }
        int count = 0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]==0) continue;
            for(int j=0;j<freq.length;j++){
                if(freq[j]==0) continue;
                if(i==j){
                    if((j<=(i/2 + 7)) || j>i || (j>100 && i<100)){
                        continue;
                    }
                    count = count + freq[j]*(freq[j]-1);
                }else{
                    if((j<=(i/2 + 7)) || j>i || (j>100 && i<100)){
                        continue;
                    }
                    count  = count + freq[i]*freq[j];
                }
            }
        }
        return count;
    }
}
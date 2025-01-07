class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        int index[] = new int[26];
        Arrays.fill(index,-1);
        for(int i=0;i<s.length();i++){
            int a = s.charAt(i)-'a';
            freq[a]++;
            if(freq[a]==1){
                index[a]=i;
            }else{
                index[a]=-1;
            }
        }
        int ans = s.length();
        for(int i : index){
            if(i!=-1){
                ans = Math.min(i,ans);
            }
        }
        if(ans==s.length()){
            return -1;
        }
        return ans;
    }
}
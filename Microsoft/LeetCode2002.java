class Solution {
    int ans = 0;
    public int maxProduct(String s) {
        helper("","",0,s);
        return ans;
    }
    boolean isPalindrome(String str){
        int n = str.length();
        if(n==0) return false;
        int l = 0;
        int r = n-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    void helper(String s1,String s2,int index,String s){
        if(index==s.length()){
            if(isPalindrome(s1) && isPalindrome(s2)){
                ans = Math.max(ans,s1.length()*s2.length());
            }
            return;
        }
        helper(s1+s.charAt(index),s2,index+1,s);
        helper(s1,s2+s.charAt(index),index+1,s);
        helper(s1,s2,index+1,s);
    }
}

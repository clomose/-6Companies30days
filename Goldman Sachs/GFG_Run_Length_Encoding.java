class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder str = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=prev){
                str.append(prev+""+count);
                count = 1;
                prev = s.charAt(i);
            }else{
                count++;
            }
        }
        str.append(prev+""+count);
        return str.toString();
    }
}
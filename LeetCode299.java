class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map = new HashMap<>();
        int x = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                x++;
            }else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        int y=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                continue;
            }
            char ch = guess.charAt(i);
            if(map.containsKey(ch)){
                y++;
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
        }
        String ans = x+"A"+y+"B";
        return ans;
    }
}
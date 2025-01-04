class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if(n<10){
            return ans;
        }
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            str.append((s.charAt(i)+""));
            if(i<9){
                continue;
            }
            String st = str.toString();
            map.put(st,map.getOrDefault(st,0)+1);
            str.delete(0,1);
        }
        Set<String> keys = map.keySet();
        for(String key : keys){
            if(map.get(key)>1){
                ans.add(key);
            }
        }
        return ans;
    }
}
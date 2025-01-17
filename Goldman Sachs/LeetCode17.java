class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        helper(0,"",digits,ans,map);
        return ans;
    }
    void helper(int index,String str,String digits,List<String> ans,HashMap<Character,String> map){
        if(index==digits.length()){
            ans.add(str);
            return;
        }
        for(int i=0;i<map.get(digits.charAt(index)).length();i++){
            String s = str + map.get(digits.charAt(index)).charAt(i);
            helper(index+1,s,digits,ans,map);
        }
    }
}
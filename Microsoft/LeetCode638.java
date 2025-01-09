class Solution {
    HashMap<List<Integer>,Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(map.containsKey(needs)){
            return map.get(needs);
        }
        int ans = 0;
        for(int i=0;i<needs.size();i++){
            ans+=price.get(i)*needs.get(i);
        }
        for(int i=0;i<special.size();i++){
            boolean isValid = true;
            for(int j=0;j<needs.size();j++){
                if(needs.get(j)<special.get(i).get(j)){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                for(int j=0;j<needs.size();j++){
                    needs.set(j,needs.get(j)-special.get(i).get(j));
                }
                int min = special.get(i).get(needs.size()) + shoppingOffers(price,special,needs);
                ans = Math.min(ans,min);
                //Backtrack
                for(int j=0;j<needs.size();j++){
                    needs.set(j,needs.get(j)+special.get(i).get(j));
                }
            }
        }
        map.put(needs,ans);
        return ans;
    }
}
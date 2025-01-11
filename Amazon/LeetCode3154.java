class Solution {
    HashMap<String,Integer> map;
    public int waysToReachStair(int k) {
        map = new HashMap<>();
        //1 --> can go down
        //0 --> cannot go down
        return helper(1,0,k,1);
    }
    private int helper(int current,int jump,int target,int down){
        String str = current+"|"+jump+"|"+down;
        if(map.containsKey(str)) return map.get(str);
        if(current>target+1) return 0;
        int ans = 0;
        if(current==target) ans++;
        if(down==1){
            ans = ans + helper(current-1,jump,target,0);
        }
        int power = (int)Math.pow(2,jump);
        ans = ans + helper(current+power,jump+1,target,1);
        map.put(str,ans);
        return ans;
    }
}
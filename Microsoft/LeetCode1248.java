class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ind = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                count++;
                map.put(count,i);
            }
        }
        int l = 1;
        int r = k;
        if(!map.containsKey(r)){
            return 0;
        }
        int ans = 0;
        while(true){
            int a = 0;
            int b = 0;
            if(!map.containsKey(r+1)){
                a = map.get(l)-map.get(l-1);
                b = nums.length - map.get(r);
                ans = ans+ a*b;
                break;
            }else{
                a = map.get(l)-map.get(l-1);
                b = map.get(r+1) - map.get(r);
                l++;
                r++;
                ans = ans + a*b;
            }
        }
        return ans;
    }
}
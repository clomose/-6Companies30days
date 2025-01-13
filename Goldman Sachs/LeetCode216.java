class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(1,0,0,k,n,list,ans);
        return ans;
    }
    void helper(int index,int sum,int taken,int k,int n,List<Integer> list,List<List<Integer>> ans){
        if(taken==k && sum==n){
            List<Integer> a = new ArrayList<>(list);
            ans.add(a);
            return;
        } 
        if(index>9 || taken>k){
            return;
        }
        list.add(index);
        helper(index+1,sum+index,taken+1,k,n,list,ans);
        list.remove(list.size()-1);
        helper(index+1,sum,taken,k,n,list,ans);
    }
}
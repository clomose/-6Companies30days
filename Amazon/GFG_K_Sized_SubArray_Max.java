class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int l = 0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if((i-l+1)<k){
                continue;
            }
            ans.add(map.lastKey());
            if(map.get(arr[l])==1){
                map.remove(arr[l]);
            }else{
                map.put(arr[l],map.get(arr[l])-1);
            }
            l++;
        }
        return ans;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer,ArrayList<Pair>> map = new HashMap<>();
        int []ans = new int[queries.length];
        int index = 0;
        for(int []q : queries){
            if(!map.containsKey(q[1])){
                ArrayList<Pair> arr = new ArrayList<>();
                for(int i=0;i<nums.length;i++){
                    int n = nums[i].length();
                    String str = nums[i].substring(n-q[1],n);
                    arr.add(new Pair(str,i));
                }
                Collections.sort(arr,(x,y) -> x.num.compareTo(y.num));
                map.put(q[1],arr);
            }
            ans[index++] = map.get(q[1]).get(q[0]-1).index;
        }
        return ans;
    }
}
class Pair{
    String num;
    int index;
    Pair(String num,int index){
        this.num = num;
        this.index = index;
    }
}
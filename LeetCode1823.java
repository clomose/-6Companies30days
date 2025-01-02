class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        int index = 0;
        while(arr.size()!=1){
            index = (index+k-1)%arr.size();
            arr.remove(index);
            index = index%arr.size();
        }
        return arr.get(0);
    }
}
class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int visited[] = new int[n+1];
        for(int i : arr){
            if(visited[i]==1){
                ans.add(i);
            }else{
                visited[i]=1;
            }
        }
        for(int i=1;i<n+1;i++){
            if(visited[i]==0){
                ans.add(i);
                break;
            }
        }
        return ans;
    }
}

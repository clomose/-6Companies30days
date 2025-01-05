class Solution {
    Random rand = null;
    TreeMap<Integer,Integer> map = null;
    int sum = 0;
    int  arr[][];
    public Solution(int[][] rects) {
        arr = rects;
        rand = new Random();
        map = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int area = (arr[i][2]-arr[i][0]+1)*(arr[i][3]-arr[i][1]+1);
            sum+=area;
            map.put(sum,i);
        }
    }
    
    public int[] pick() {
        int randInt = rand.nextInt(sum);
        int index = map.higherKey(randInt);
        int rec = map.get(index);
        int x =  rand.ints(arr[rec][0],arr[rec][2]+1).findFirst().getAsInt();
        int y =  rand.ints(arr[rec][1],arr[rec][3]+1).findFirst().getAsInt();
        int ans[] = {x,y};
        return ans;        
    }
}


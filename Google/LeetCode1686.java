class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = bobValues.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.sum-x.sum);
        for(int i=0;i<n;i++){
            int sum = aliceValues[i]+bobValues[i];
            pq.add(new Pair(sum,i));
        }
        int sum1 = 0;
        int sum2 = 0;
        boolean flag = true;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int index = p.index;
            if(flag){
                sum1+=aliceValues[index];
            }else{
                sum2+=bobValues[index];
            }
            flag = !flag;
        }
        if(sum1>sum2){
            return 1;
        }
        if(sum2>sum1){
            return -1;
        }
        return 0;
    }
}
class Pair{
    int sum;
    int index;
    Pair(int sum,int index){
        this.sum = sum;
        this.index = index;
    }
}
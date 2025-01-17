class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for(int i : asteroids){
            if(i<=sum){
                sum+=i;
            }else{
                return false;
            }
        }
        return true;
    }
}
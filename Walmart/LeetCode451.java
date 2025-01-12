class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> y.num-x.num);
        Set<Character> keys = map.keySet();
        for(char key : keys){
            pq.add(new pair(key,map.get(key)));
        }
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            pair p = pq.remove();
            for(int i=0;i<p.num;i++){
                str.append(p.c+"");
            }
        }
        return str.toString();
    }
}
class pair{
    char c;
    int num;
    pair(char c,int num){
        this.c = c;
        this.num = num;
    }
}
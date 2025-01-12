class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.freq==y.freq ? x.str.compareTo(y.str) : y.freq-x.freq);
        Set<String> keys = map.keySet();
        for(String key : keys){
            pq.add(new Pair(key,map.get(key)));
        }
        while(k>0){
            Pair p = pq.remove();
            ans.add(p.str);
            k--;
        }
        return ans;
    }
}
class Pair{
    String str;
    int freq;
    Pair(String str,int freq){
        this.str = str;
        this.freq = freq;
    }
}

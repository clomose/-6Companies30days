class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        char[] order = {'!','#','$','%','&','*','?','@','^'};
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length;i++){
            map.put(order[i],i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(map.get(nuts[j])>map.get(nuts[j+1])){
                    char temp = nuts[j];
                    nuts[j] = nuts[j+1];
                    nuts[j+1] = temp;
                }
                if(map.get(bolts[j])>map.get(bolts[j+1])){
                    char temp = bolts[j];
                    bolts[j] = bolts[j+1];
                    bolts[j+1] = temp;
                }    
            }
        }
    }
}
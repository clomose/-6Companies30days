class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for(ListNode node : lists){
            ListNode a = node;
            while(a!=null){
                map.put(a.val,map.getOrDefault(a.val,0)+1);
                a = a.next;
            }
        }
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            for(int i=0;i<map.get(key);i++){
                ListNode node = new ListNode(key);
                temp.next = node;
                temp = temp.next;
            }
        }
        return ans.next;
    }
}
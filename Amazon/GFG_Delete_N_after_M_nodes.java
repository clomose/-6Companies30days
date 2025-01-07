class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        if(n==0) return;
        if(m==0){
            head = null;
            return;
        }
        
        Node start = null;
        Node end = null;
        Node temp = head;
        
        while(temp!=null){
            int c = 1;
            while(temp!=null && c<m){
                temp = temp.next;
                c++;
            }
            start = temp;
            if(start==null) break;
            c = 0;
            while(temp!=null && c<=n){
                temp = temp.next;
                c++;
            }
            end = temp;
            
            start.next = end;
        }
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    void add(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    void delete(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        add(node);
        map.put(key,head.next);
        return head.next.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==size){
                Node a = tail.prev;
                delete(a);
                Node node = new Node(key,value);
                add(node);
                map.remove(a.key);
                map.put(key,head.next);
            }else{
                Node node = new Node(key,value);
                add(node);
                map.put(key,head.next);
            }
            
        }else{
            Node node = map.get(key);
            delete(node);
            node.val = value;
            add(node);
            map.put(key,head.next);
        }
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        if (!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;

    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() >= capacity){
            // for least removal
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        
        }

        Node node = map.getOrDefault(key, null);

        if(node != null){
            node.value = value;
            removeNode(node);
        } else{
            node = new Node(key, value);
        }

        addNode(node);
        map.put(key, node);
    }

    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void addNode(Node node){
        Node next = head.next;

        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }
}

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
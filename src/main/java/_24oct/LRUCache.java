package _24oct;

import java.util.HashMap;

class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
        public Node(){

        }
    }
    int size;
    Node head;
    Node end;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        size = capacity;
        head = new Node();
        end = new Node();
        head.next = end;
        end.prev = head;
        map = new HashMap<>();

    }

    public void moveToEnd(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        addToEnd(n);

    }

    public void addToEnd(Node n){
        end.prev.next = n;
        n.prev = end.prev;
        n.next = end;
        end.prev = n;
    }

    public void removeHead(){
        Node tmp = head.next;
        head.next = tmp.next;
        tmp.next.prev = head;
        tmp.prev = null;
        tmp.next = null;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node n = map.get(key);
            moveToEnd(n);
            return n.val;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            map.put(key,n);
            moveToEnd(n);
        }else{
            if(map.size() == size){
                map.remove(head.next.key);
                removeHead();
            }
            Node n = new Node(key,value);
            addToEnd(n);
            map.put(key,n);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
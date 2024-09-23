package _24sep;

import java.util.HashMap;

class LRUCache {

    // node需要保存key，用于从map移除元素
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }

        public Node(){

        }
    }

    HashMap<Integer,Node> map = new HashMap<>();
    int c;
    Node pHead;
    Node pTail;

    public LRUCache(int capacity) {
        this.c = capacity;
        pHead = new Node();
        pTail = new Node();
        pHead.next = pTail;
        pTail.prev = pHead;
    }

    public void addToTail(Node node){
        pTail.prev.next = node;
        node.prev = pTail.prev;
        pTail.prev = node;
        node.next = pTail;
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void moveToTail(Node node){
        deleteNode(node);
        addToTail(node);
    }

    // c r u d
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.val;

    }

    // 记得把新创建或者修改过的node重新放回map
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() == c){
                // 先移除出map
                map.remove(pHead.next.key);
                deleteNode(pHead.next);
            }
            Node node = new Node(key,value);
            addToTail(node);
            map.put(key,node);
        }else{
            Node node = map.get(key);
            node.val = value;
            map.put(key,node);
            moveToTail(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
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
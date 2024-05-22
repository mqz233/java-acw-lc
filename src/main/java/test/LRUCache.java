package test;

import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author：Yan Zhaoyang
 * @Package：test
 * @Project：java-acw-lc
 * @name：LRUCache
 * @Date：2024/4/30 21:57
 * @Filename：LRUCache
 * @Desc：
 */
class LRUCache {

    class Node{
        Node prev;
        Node next;

        int key;

        int value;


        public Node(int key,int value){
            this.value = value;
        }

        public Node(){}

    }

    // 缓存
    public Node[] map = new Node[10001];

    public int capacity;

    public Node first;

    public Node last;

    public int size;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.first = new Node();
        this.last = new Node();
        this.first.next = this.last;
        this.last.prev = this.first;
    }

    public void addLast(int key,int value){
        this.last.next = new Node(key,value);
        this.last.next.prev = this.last;
        this.last = this.last.next;
        map[key] = this.last;
        size++;
    }

    public void remove(int key){
        Node node = map[key];
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map[key] = null;
        size--;
    }

    public void removeFirst(){
        remove(this.first.key);
    }

    public void put(int key, int value){
        // 查看缓存中是否存在
        if (map[key] == null){
            // 不存在直接加到末尾
            addLast(key,value);
            // 如果size大于capacity，移除头部
            if (size>capacity){
                removeFirst();
            }
        }else {
            // 存在则更新缓存（先移除，在加到末尾）
            remove(key);
            addLast(key,value);
        }
    }

    public int get(int key){
        if (map[key] == null){
            return -1;
        }else {
            Node node = map[key];
            remove(node.key);
            addLast(node.key, node.value);
            return map[key].value;
        }
    }



}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
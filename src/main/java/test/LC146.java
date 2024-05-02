package test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author：Yan Zhaoyang
 * @Package：test
 * @Project：java-acw-lc
 * @name：LC146
 * @Date：2024/4/30 20:20
 * @Filename：LC146
 * @Desc：
 */
public class LC146 {

    HashMap<Integer, Integer> map;

    Node start = null;

    Node end = null;

    int capacity;

    public LC146(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>(capacity);

    }

    public int get(int key) {

        // 不存在返回-1
        if (!map.containsKey(key)){
            return -1;
        }

        // 更新位置
        update(key);

        return map.get(key);


    }

    public void put(int key, int value) {
        
        // key不存在
        if (!map.containsKey(key)){
            // map满了
            if (map.size() == capacity){

                // 节点操作
                update(key);
                Node e = this.end;
                Node tmp = e.pre;
                map.remove(e.val);
                Node node = new Node(key);
                if (tmp!=null){
                    tmp.next = node;
                    node.pre = tmp;
                    node.next = null;
                    this.end = node;
                }else {
                    // 只有一个节点
                    map.clear();
                    map.put(key,value);
                    this.start = new Node(key);
                    this.end = this.start;
                }

                // map操作
                map.remove(e.val);
                map.put(key,value);
                
            }
            // map没满，插入到尾部
            else {
                // 节点操作
                Node node = new Node(key);
                Node tmp = this.end;
                if (tmp!=null){
                    tmp.next = node;
                    node.pre = tmp;
                    node.next = null;
                    this.end = node;
                }else {
                    this.start = node;
                    this.end = this.start;
                }
                // map操作
                map.put(key, value);


            }
        }else {
            // key存在，更新值，然后移动到末尾
            map.put(key,value);
            update(key);
        }
        
        

    }

    // 更新node在链表中的位置
    public void update(int key){

        Node tmp = this.start;
        while (tmp!=null){
            // 移动该节点到末尾
            if (tmp.val == key){
                // 头节点移动到尾节点
                if (tmp.pre == null){
                    this.start = tmp.next;
                    end.next = tmp;
                    tmp.next = null;
                    tmp.pre = end;
                    end = tmp;
                }else if(tmp.next != null){
                    // 非头尾节点，移动到尾节点
                    tmp.pre.next = tmp.next;
                    tmp.next.pre = tmp.pre;
                    end.next = tmp;
                    tmp.pre = end;
                    end = tmp;
                }else {
                    // 尾节点无需移动
                }
                break;
            }
            tmp = tmp.next;
        }

    }

    public static void main(String[] args) {
        LC146 lc146 = new LC146(2);
        lc146.put(1,1);
        lc146.put(2,2);
        lc146.get(1);
        lc146.put(3,3);
        lc146.get(2);

    }

}

class Node {
    int val;

    Node pre;

    Node next;

    public Node(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }

}

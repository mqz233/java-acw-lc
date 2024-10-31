package _24oct;

import java.util.ArrayDeque;

public class CursedList {
    public ListNode formatList(ListNode head){
        ArrayDeque<ListNode> q = new ArrayDeque<>();
        boolean flag = true;
        while(head!=null){
            if(flag){
                q.addFirst(head);
            }else{
                q.addLast(head);
            }
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            flag = !flag;
        }
        ListNode pHead = new ListNode(1);
        ListNode cur = q.removeFirst();
        pHead.next = cur;

        while(!q.isEmpty()){
            cur.next = q.removeFirst();
            cur = cur.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp =head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        CursedList cursedList = new CursedList();
        cursedList.formatList(tmp);
    }

}

package test;

public class LC206 {
    public ListNode reverseList(ListNode head) {

        if (head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        cur.next = pre;
        return cur;


    }

    // 递归实现
    // head.next.next = head;
    // head.next = null;
    public ListNode reverseList2(ListNode head) {

        if (head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        cur.next = pre;
        return cur;


    }

}

package carl.node;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        // 非递归法
        if (head == null) {
            return null;
        }
        // ***初始pre为null
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;


    }



}

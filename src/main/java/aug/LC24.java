package aug;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode prevHead = new ListNode();
        ListNode l0 = prevHead;
        prevHead.next = l1;
        if(l2 == null) return l1;
        while( l2 != null){
            ListNode tmp = l2.next;
            l2.next = l1;
            l1.next = tmp;
            l0.next = l2;
            if(tmp != null){
                l0 = l1;
                l1 = tmp;
                l2 = tmp.next;
            }else{
                break;
            }
        }

        return prevHead.next;

    }
}

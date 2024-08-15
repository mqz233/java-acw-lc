package aug;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        for(int i=0;i< n;i++){
            node = node.next;
        }
        ListNode node2 = head;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode node3 = prev;
        while(node != null){
            node = node.next;
            prev = node2;
            node2 = node2.next;
        }
        prev.next = node2.next;

        return node3.next;
    }
}

package aug;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return new ListNode();
        ListNode node1 = head;
        ListNode node2 = node1.next;
        node1.next = null;
        while(node2!=null){

            ListNode tmp = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = tmp;
        }
        return node1;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        LC206 lc206 = new LC206();
        lc206.reverseList(listNode);
    }
}

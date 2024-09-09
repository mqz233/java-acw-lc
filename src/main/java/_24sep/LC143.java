package _24sep;

public class LC143 {
    public void reorderList(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        if(count == 1) return;
        int half = count%2==0?count/2:count/2+1;
        ListNode prev = new ListNode();
        prev.next = head;
        node = head;
        while(half>0){
            prev = node;
            node = node.next;
            half--;
        }

        prev.next = null;
        node = rev(node);
        ListNode n1 = head;
        while(node!=null){
            ListNode next = node.next;
            ListNode tmp = n1.next;
            n1.next = node;
            node.next = tmp;
            n1 = tmp;
            node = next;
        }

    }

    public ListNode rev(ListNode node){
        ListNode prev = null;
        while(node.next!=null){
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        node.next = prev;
        return node;
    }

}

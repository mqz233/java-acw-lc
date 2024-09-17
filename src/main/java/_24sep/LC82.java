package _24sep;

public class LC82 {
    public void deleteDuplicates(ListNode head) {
        ListNode prev = head;
        while(prev.next!= head){
            prev = prev.next;
        }
        ListNode p = prev;
        ListNode node = head;
        while(true){
            if(node == p){
                break;
            }
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        node.next = prev;
        System.out.println(1);
    }

    public static void main(String[] args) {
        LC82 lc82 = new LC82();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;

        lc82.deleteDuplicates(l1);
    }
}

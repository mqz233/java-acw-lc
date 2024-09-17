package _24sep;

public class LCR26 {
    public void reorderList(ListNode head) {
        // 计算长度
        ListNode prev = new ListNode();
        prev.next  =head;
        ListNode p1 = prev;
        ListNode p2 = prev;
        while(p2!=null){
            if(p2.next == null){
                break;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // prev是前半的最后一个
        // node是后半开始
        p1.next = null;
        // 反转后半
        p1 = null;
        while(p2 != null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        // 后半插入前半 （注意后半比较短）
        p2 = head;
        while(p1 != null){
            ListNode tmp1 = p1.next;
            ListNode tmp2 = p2.next;
            p2.next = p1;
            p1.next = tmp2;
            p1 = tmp1;
            p2 = tmp2;
        }
    }

    public static void main(String[] args) {
        LCR26 lcr26 = new LCR26();
        ListNode head;
        ListNode node = new ListNode(1);
        head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        lcr26.reorderList(head);
    }
}

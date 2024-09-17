package _24sep;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 9 9 9 9 9 9 9
        // 9 9 9 9

        ListNode head = null;
        ListNode tail = null;
        int last = 0;
        while(l1!=null || l2!=null){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            int sum = v1+v2+last;
            if(sum >= 10){
                last = 1;
                sum = sum%10;
            }else{
                last = 0;
            }
            if(head == null){
                head = new ListNode(sum);
                tail = head;
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if(l1 != null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }
        if(last != 0){
            tail.next = new ListNode(last);
        }
        return head;
    }
}

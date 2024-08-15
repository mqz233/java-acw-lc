package aug;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSize = 0;
        int bSize = 0;
        ListNode n1 = headA;
        while(n1 !=null) {
            n1 = n1.next;
            aSize++;
        }
        ListNode n2 = headB;
        while(n2 != null){
            n2 = n2.next;
            bSize++;
        }
        int sub = 0;
        n1 = headA;
        n2 = headB;
        if(aSize>bSize){
            sub = aSize - bSize;
            while(sub>0){
                n1 = n1.next;
                sub--;
            }
        }else{
            sub = bSize - aSize;
            while(sub>0){
                n2 = n2.next;
                sub--;
            }
        }

        while(n1!=null){
            if(n1 == n2) return n1;
            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }
}

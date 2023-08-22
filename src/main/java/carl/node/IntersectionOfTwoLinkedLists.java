package carl.node;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        int distance = lenA > lenB ? lenA - lenB : lenB - lenA;
        if (lenA > lenB) {
            while (distance > 0) {
                headA = headA.next;
                distance--;
            }
        } else {
            while (distance > 0) {
                headB = headB.next;
                distance--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;

    }

}

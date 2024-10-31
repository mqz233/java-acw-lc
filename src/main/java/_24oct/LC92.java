package _24oct;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC92 {
    public ListNode[] reverse(ListNode cur, int count){
        ListNode prev = null;
        ListNode tmp1 = cur;
        while(count>0){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            count--;
        }
        return new ListNode[]{prev,tmp1};
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pHead = new ListNode();
        pHead.next = head;
        ListNode prev = pHead;
        int count = 1;
        while(count<left){
            prev = prev.next;
            count++;
        }
        ListNode next = prev;
        while(count<=right){
            next = next.next;
            count++;
        }
        ListNode[] nodes = reverse(prev.next,right-left+1);
        prev.next = nodes[0];
        nodes[1].next = next;
        return pHead.next;

    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode listNode = new ListNode(1);
        head = listNode;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        LC92 lc92 = new LC92();
        lc92.reverseBetween(head,2,4);
    }
}
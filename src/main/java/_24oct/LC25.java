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
class LC25 {
    public ListNode[] fnc(ListNode n,int k){
        ListNode tmp = n;
        ListNode prev = null;
        while(k>0){
            ListNode tmp2 = n.next;
            n.next = prev;
            prev = n;
            n = tmp2;
            k--;
        }
        return new ListNode[]{tmp,prev};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode();
        pHead.next = head;
        ListNode prev = pHead;
        ListNode cur = head;
        ListNode next;
        int count = 0;
        while(true){
            ListNode tmp = cur;
            while(cur!=null){
                count++;
                cur = cur.next;
                if(count == k){
                    break;
                }
            }
            if(count != k){
                break;
            }
            next = cur;
            ListNode[] nodes = fnc(tmp,k);
            prev.next = nodes[1];
            nodes[0].next = next;
            prev = nodes[0];


        }
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tmp = listNode;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        LC25 lc25 = new LC25();
        lc25.reverseKGroup(tmp,2);
    }
}
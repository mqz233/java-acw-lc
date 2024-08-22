package _24july;

/**
 * @Desc：题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class LC206 {
    public ListNode fnc(ListNode dummy,ListNode prev,ListNode cur){
        if (cur!=null){
           ListNode node =  fnc(dummy,cur,cur.next);
           if (prev != dummy){
               cur.next = prev;
           }else {
               cur.next = null;
           }
            return node;
        }else{
            return prev;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        return fnc(tmpHead,tmpHead,head);
    }
}

package _24july;

/**
 * @Desc：题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * <p>
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * <p>
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode node = tmpHead;
        while(node.next!=null){
            if (node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return tmpHead.next;
    }
}

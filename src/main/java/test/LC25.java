package test;
import java.util.*;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k){
        // 虚拟头节点
        ListNode d = new ListNode(1);
        d.next = head;
        // pre记录上一轮反转过后的最后一个节点，初始是dummy
        ListNode pre = d;
        // end应为本轮的最后一个节点，从pre next k次，不为空，说明够
        ListNode end = pre;

        while (end!=null){
            // 先看是否够k个节点
            int count = k;
            while (count>0&&end!=null){
                end = end.next;
                count--;
            }
            // end == null，说明不够k个，跳出循环
            if (end==null){
                break;
            }
            // start应为pre.next
            ListNode start = pre.next;
            // 记录一下endNext，之后要用
            ListNode endNext = end.next;
            // 反转 start到end
            reverse(start,end);
            // 反转之后更新pre end
            // pre后面应该变成end
            pre.next = end;
            // start后面应该变成endNext
            start.next = endNext;
            // pre应变成start
            pre = start;
            end = pre;

        }

        return d.next;
    }

    private void reverse(ListNode start, ListNode end){
        // 普通反转链表，不用管最开始的pre
        ListNode cur = start;
        ListNode pre = new ListNode(1);
        while (cur!=end){

            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        cur.next = pre;
    }

}

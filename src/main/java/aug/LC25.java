package aug;

public class LC25 {
    //  1-2-3-4-5 k=2
    // 2-1-4-3-5
    // start = 1 end =1
    // k=2 -> end =2
    // 1-2之间反转 start = 1 end = 2
    // start.next = tmp (tmp = end.next)
    // end.next = prev
    // 如果这是第一次反转成功，那么要记录他作为最后的返回值
    // 还要记录这一轮最后一个节点start作为roundLast
    // 如果roundLast不为空，那么roundLast.next就为end（这一轮的起点）
    // roundLast = start
    // end.next = 3 下一轮 start = 3 end =3
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode res = head;
        ListNode node = head;
        ListNode roundLast = null;
        int resCount = 0;
        while(node != null){
            int count = 0;
            while(node != null){
                count++;
                if(count == k){
                    break;
                }
                node = node.next;
            }
            if(count < k) break;
            ListNode left = start;
            ListNode prev = null;
            while(left!=node){
                ListNode tmp = left.next;
                left.next = prev;
                prev = left;
                left = tmp;

            }
            ListNode tmp = node.next;
            node.next = prev;
            start.next = tmp;
            if(roundLast != null){
                roundLast.next = node;
            }
            resCount++;
            if(resCount == 1){
                res = node;
            }
            roundLast = start;
            start = tmp;
            node = tmp;
        }

        return res;

    }

    public static void main(String[] args) {
        LC25 lc25 = new LC25();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        lc25.reverseKGroup(n1,2);
    }
}

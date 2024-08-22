package _24aug;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node!=null){
            size++;
            node = node.next;
        }
        if(size == 1) return true;
        int num = size/2-1;
        node = head;
        ListNode node2 = node.next;
        node.next = null;
        while(num > 0){
            ListNode tmp = node2.next;
            node2.next = node;
            node = node2;
            node2 = tmp;
            num--;
        }
        if(size%2!=0) node2 = node2.next;
        while(node!=null){
            if(node.val != node2.val) return false;
            node = node.next;
            node2 = node2.next;
        }
        return true;
    }
}

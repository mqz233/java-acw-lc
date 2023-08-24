package carl.node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycle {
    public ListNode detectCycle(ListNode head) {

        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur!=null){
            if(set.contains(cur)){
                return cur;
            }
            else{
                set.add(cur);
            }
            cur = cur.next;

        }

        return null;



    }
}

package _24aug;

public class LC2 {
    public ListNode fnc(ListNode l1, ListNode l2, boolean flag){
        int val = 0;
        if(flag) val += 1;
        if(l1 != null) val+= l1.val;
        if(l2 != null) val += l2.val;
        boolean next = false;
        if(val >= 10){
            val = val%10;
            next = true;
        }
        ListNode node = new ListNode(val);
        if(l1 != null && l2 != null){
            node.next = fnc(l1.next,l2.next,next);
        }else{
            if(l1 != null){
                node.next = fnc(l1.next,null,next);
            }else if(l2 != null){
                node.next = fnc(null,l2.next,next);
            }else{
                // 两个节点都为空了
                // 如果上一次进位了，那么创建一个节点
               if(flag){
                   node.next = null;
               }else{
                   // 不创建节点
                   return null;
               }
            }
        }

        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return fnc(l1,l2,false);
    }
}

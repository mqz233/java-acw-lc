package _24aug;

public class LC21_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode prevHead = new ListNode();
        ListNode prev = prevHead;
        while(list1!=null && list2 != null){
            if(list1.val<list2.val){
                prev.next = list1;
                prev = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                prev = list2;
                list2 = list2.next;
            }

        }


        if(list1!=null){
            prev.next = list1;
        }else{
            prev.next = list2;
        }

        return prevHead.next;

    }
}

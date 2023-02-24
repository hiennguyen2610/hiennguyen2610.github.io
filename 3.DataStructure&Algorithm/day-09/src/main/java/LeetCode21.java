public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-9999);
        ListNode current = dummy;

        // merge
        while (list1 != null && list2 != null) {
            // ưu  tiên lấy phần tử nhỏ hơn để add vào kq
            if (list1.val < list2.val) {
                current.next = list1;
//                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
//                current = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // list1 hết
        if (list1 != null) {
            current.next = list1;
        }
        if(list2 != null) {
            current.next = list2;
        }
        // list2 hết
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}

class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return dummyHead.next;
    }
}

class SortLinkedList {
    public ListNode sortLinkedList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode node = head, sub1 = head, sub2 = head;
            int cnt = 0;
            while (node != null) {
                cnt++;
                node = node.next;
            }
            int mid = cnt >> 1;
            cnt = 0;
            while (sub2 != null && cnt < mid-1) {
                cnt++;
                sub2 = sub2.next;
            }
            ListNode sub2Head = sub2.next;
            sub2.next = null;

            return mergeLinkedList(sortLinkedList(sub1), sortLinkedList(sub2Head));
        }
    }
    
    private ListNode mergeLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) { return null; }
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            dummy.next = l1;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            dummy = dummy.next;
            l2 = l2.next;
        }
        return dummyHead.next;
    }
}

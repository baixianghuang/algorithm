class ReorderList {
    public void reorderList(ListNode head) {
        // iteratively move tail to the insertion position
        if (head == null || head.next == null) {
            return;
        }
        ListNode insert = head;  // position where nodes from tail insert after
        ListNode tail = head, preTail = head;
        while (tail.next != null) {
            preTail = tail;
            tail = tail.next;
        }
        while (true) {
            System.out.println(insert.val + " " + preTail.val + " " + tail.val);
            preTail.next = null;
            ListNode temp = insert.next;
            insert.next = tail;
            tail.next = temp;
            while (tail.next != null) {
                preTail = tail;
                tail = tail.next;
            }
            if (insert.next.next != null) { insert = insert.next.next; }
            if (insert.next == tail || insert.next == null) { break; }
        }
    }

    public void reorderListApproach2(ListNode head) {
        // reverse the second half of the list and combine them together
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, preSlow = null;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // after the loop above, slow points to the half point, then cut the list and reverse the right sub list
        preSlow.next = null;
        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }

        // merge two sub lists
        ListNode head1 = head, head2 = pre, end = null;
        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            end = head2;
            head1 = temp1;
            head2 = temp2;
        }
        if (head1 != null) { end.next = head1; }
        if (head2 != null) { end.next = head2; }
    }
}

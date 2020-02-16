class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, nex = head.next;
        while (cur != null) {
            pre.next = nex;
            cur.next = nex.next;
            nex.next = cur;
            pre = cur;
            cur = cur.next;
            if (cur != null && cur.next == null) { break; }
            if (cur != null && cur.next != null) {
                nex = cur.next;
            }
        }
        return dummy.next;
    }
}

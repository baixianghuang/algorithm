class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Time complexity: O(n)
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, last = cur;
        for (int i = 0; i < k-1 && last != null; i++, last = last.next) { }

        while (last != null) {
            ListNode subHead = reverseList(cur, k), subTail = subHead;
            for (int i = 0; i < k-1; i++, subTail = subTail.next) { }
//        System.out.println(subTail.val);
            pre.next = subHead;
            pre = subTail;
            cur = subTail.next;
            last = cur;
            for (int i = 0; i < k-1 && last != null; i++, last = last.next) { }
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode node, int x) {
        // reverse x nodes
        ListNode pre = null, cur = node;
        int cnt = 0;
        while (cur != null && cnt < x) {
            cnt++;
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        node.next = cur;
        return pre;
    }
}

class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // Time complexity: O(n)
        if (head == null) {
            return null;
        }
        ListNode iHead = new ListNode(0), jHead = new ListNode(0);
        ListNode i = iHead, j = jHead;
        int cnt = 1;
        while (head != null) {
            if (cnt % 2 != 0) {
                i.next = head;
                i = i.next;
            }
            else {
                j.next = head;
                j = j.next;
            }
            head = head.next;
            cnt++;
        }
        j.next = null;
        i.next = jHead.next;
        return iHead.next;
    }
}

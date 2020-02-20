class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead, node = dummy, end = dummy;
        dummy.next = head;
        int cnt = 0;
        while (cnt <= n && end != null) {
            cnt++;
            end = end.next;
        }

        while (end != null) {
            node = node.next;
            end = end.next;
        }
        System.out.println(node.val);
        node.next = node.next.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEndApproach2(ListNode head, int n) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        int length = cnt;

        // delete the first node
        if (n == length) {
            return head.next;
        } else {
            cnt = 0;
            node = head;
            // let the node stop at the previous position of the node needs to be deleted
            while (node != null && cnt < length - n - 1) {
                cnt++;
                node = node.next;
            }
            node.next = node.next.next;
        }
        return head;
    }
}

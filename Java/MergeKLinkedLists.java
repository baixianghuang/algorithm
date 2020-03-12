class MergeKLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Time complexity: O(nlogk)
        if (lists == null || lists.length == 0) { return null; }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!pq.isEmpty()) {
            node.next = pq.remove();
            node = node.next;
        }
        if (node != null) { node.next = null; }  // make sure there is no loop formed in the for loop above
        return dummy.next;
    }
}

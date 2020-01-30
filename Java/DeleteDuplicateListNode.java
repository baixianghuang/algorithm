class DeleteDuplicateListNode {
    public ListNode deleteDuplicateListNode(ListNode head) {
        // Note that the given linked list is sorted
        // Time complexity: O(n)
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }
    
    public ListNode deleteDuplicateListNodeApproach2(ListNode head) {
        // Use additional space
        if (head == null) {
            return null;
        }
        ListNode node = head;
        Map<ListNode, Integer> map = new LinkedHashMap<>();
        while (node != null) {
            if (!map.containsValue(node.val)) {
                map.put(node, node.val);
            }
            node = node.next;
        }
        Iterator<ListNode> iterator = map.keySet().iterator();
        ListNode pre = iterator.next();
        while (iterator.hasNext()) {
            ListNode cur = iterator.next();
            pre.next = cur;
            pre = cur;
        }
        //pre currently point to the last node that may have duplicate
        if (pre.next != null && pre.next.val == pre.val) {
            pre.next = null;
        }
        return head;
    }
}

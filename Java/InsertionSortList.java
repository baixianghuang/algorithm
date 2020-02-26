class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            if (pre.val >= cur.val) { pre = dummy; }

            while (pre.next != null && pre.next.val < cur.val) {  // let pre points to the last node of sorted list
                pre = pre.next;
            }
            
            // insert cur into pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = nex;
        }
        return dummy.next;
    }

    public ListNode insertionSortListApproach2(ListNode head) {
        // convert the linked list into arraylist
        if (head == null || head.next == null) { return head; }
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j-1) > list.get(j)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }

        node = head;
        for (int e : list) {
            node.val = e;
            node = node.next;
        }
        return head;
    }
}

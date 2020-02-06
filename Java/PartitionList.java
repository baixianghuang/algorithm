class PartitionList {
    public ListNode partitionList(ListNode head, int x) {
        // Time complexity: O(n)
        if (head == null) {
            return null;
        }
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode dummyHead1 = dummy1, dummyHead2 = dummy2;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                dummy1.next = node;
                dummy1 = dummy1.next;
            }
            else {
                dummy2.next = node;
                dummy2 = dummy2.next;
            }
            node = node.next;
        }
        // join two dummy sublist
        dummy1.next = dummyHead2.next;
        // when dummy2 doesn't point to the last node, a list loop may be formed without this line
        dummy2.next = null;
        return dummyHead1.next;
    }

    public ListNode partitionListApproach2(ListNode head, int x) {
        // use extra space
        if (head == null) {
            return null;
        }
        ListNode node = head;
        List<Integer> ls = new ArrayList<>();
        while (node != null) {
            ls.add(node.val);
            node = node.next;
        }
        int k = 0;  // ls[0...k] < x
        for (int i = 0; i < ls.size(); i++) {
            int n = ls.get(i);
            if (n < x) {
                ls.remove(i);
                ls.add(k, n);
                k++;
            }
        }
        ListNode cur = new ListNode(ls.get(0));
        ListNode ans = cur;
        for (int i = 0; i+1 < ls.size(); i++) {
            ListNode nex = new ListNode(ls.get(i+1));
            cur.next = nex;
            cur = nex;
        }
        return ans;
    }
}

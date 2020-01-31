class PartitionList {
    public ListNode partitionList(ListNode head, int x) {
        // Time complexity: O(n)
        // i points to the sublist whose node.val < x,
        // j points to the sublist whose node.val >= x
        if (head == null) {
            return null;
        }
        ListNode node = head, iHead = new ListNode(0), jHead = new ListNode(0);
        ListNode i = iHead, j = jHead;
        while (node != null) {
            if (node.val < x) {
                i.next = node;
                i = i.next;
            }
            else {
                j.next = node;
                j = j.next;
            }
            node = node.next;
        }
        j.next = null;  // when j is not the last node, without this line, a list loop may be formed
        i.next = jHead.next;
        return iHead.next;
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

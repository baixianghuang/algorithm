class ReverseBetweenList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Time complexity: O(n)
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++, pre = pre.next) {}  // pre points to the (m-1)th node
        ListNode subHead = reverseList(pre.next, n-m);
        System.out.println(pre.val+" "+subHead.val);
        pre.next = subHead;
        return dummy.next;
    }
    
    public ListNode reverseBetweenListApproach2 (ListNode head, int m, int n) {
        // this approach use more extra space
        if (head == null || m == n) {
            return head;
        }

        // create a sublist then reverse it
        // also, clone the original list
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead, node = head;
        ListNode repHead = new ListNode(head.val), rep = repHead;
        ListNode connLeft = head, connRight = null;
        int cnt = 0;
        while (node != null) {
            cnt++;
            if (cnt >= m && cnt <= n) {
                dummy.next = new ListNode(node.val);
                dummy = dummy.next;
            } else if (cnt == m - 1) {
                connLeft = node;
            } else if (cnt == n + 1) {
                connRight = rep;
            }
            node = node.next;
            if (node != null) {
                rep.next = new ListNode(node.val);
                rep = rep.next;
            }
        }
        dummy.next = null;
        ListNode subHead = reverseList(dummyHead.next), subTail = subHead;
        while (subTail.next != null) { subTail = subTail.next; }

//        System.out.println(connLeft.val+" "+connRight.val);
        // connect the reversed sublist with appropriate nodes
        if (m == 1) {
            head = subHead;
        } else {
            connLeft.next = subHead;  // without rep (connLeft and connRight point to a same list), the list is not complete after this line
        }
        subTail.next = connRight;
        return head;
    }
    
    public ListNode reverseList(ListNode head, int x) {
        // reverse the list from head to the n-th node
        ListNode pre = null, cur = head;
        int cnt = 0;
        while (cur != null && cnt <= x) {
            cnt++;
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        head.next = cur;
        return pre;
    }
    
    public ListNode reverseList(ListNode head) {
        // reverse the entire list
        ListNode pre = null, cur = head, nex = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nex;
            if (nex != null) { nex = nex.next; }
        }
        return pre;
    }
}

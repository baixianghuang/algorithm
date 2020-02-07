class deleteListDuplicatesII {
    public ListNode deleteListDuplicatesII(ListNode head) {
        // delete all nodes that have duplicate numbers from a sorted linked list
        // Time complexity: O(n)
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            // after the while loop, cur points to the first node whose next node is a node with different val
            if (pre.next == cur) {
                pre = pre.next;
            }
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public ListNode deleteListDuplicatesIIApproach2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        while (cur != null) {
            int cnt = 0;
            ListNode temp = cur;
            while (temp != null && temp.val == cur.val) {
                cnt ++;
                temp = temp.next;
            }
            if (cnt > 1) {
                pre.next = temp;
            }
            else {
                pre = cur;
            }
            cur = temp;
        }
        return dummyHead.next;
    }
    
    public ListNode deleteListDuplicatesIIApproach3(ListNode head) {
        // use a map to store the frequency of each node's value
        if (head == null || head.next == null) {
            return head;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.get(cur.val) == null ? 1 : map.get(cur.val)+1);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                dummy.next = new ListNode(key);
                dummy = dummy.next;
            }
        }
        dummy.next = null;
        return dummyHead.next;
    }
}

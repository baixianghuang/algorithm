class AddTwoNumbersFromListII {
    public ListNode addTwoNumbersFromListII (ListNode l1, ListNode l2) {
        // given two non-empty linked lists representing two non-negative integers
        // Add the two numbers and return it as a linked list.
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null ? l1.val : 0);
            int n2 = (l2 != null ? l2.val : 0);
            int sum = n1 + n2 + carry;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            carry = sum / 10;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        if (carry == 1) { dummy.next = new ListNode(1); }
        return reverseList(dummyHead.next);
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, nex = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nex;
            if (nex != null) { nex = nex.next; }
        }
        return pre;
    }
    
    public ListNode addTwoNumbersFromListIIApproach2(ListNode l1, ListNode l2) {
        // Instead of modifying the input list, this approach uses stacks
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = null;
        int carry = 0;
        while (!s1.empty() || !s2.empty() || carry != 0) {
            if (!s1.empty()) { carry += s1.pop(); }
            if (!s2.empty()) { carry += s2.pop(); }
            ListNode dummy = new ListNode(carry % 10);
            dummy.next = dummyHead;
            dummyHead = dummy;
            carry /= 10;
        }
        return dummyHead;
    }
}

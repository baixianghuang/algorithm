class AddTwoLists {
    public ListNode addTwoLists(ListNode l1, ListNode l2) {
        // The digits are stored in reverse order and each of their nodes contain a single digit
        // the two numbers do not contain any leading zero
        // Time complexity: O(max(list1.length, list2.length))
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        // if using "l1 != null && l2 != null" as condition, have to deal with the rest of longer list
        while (l1 != null || l2 != null) {
            // handle the rest of longer list smartly
            int n1 = (l1 == null ? 0 : l1.val);
            int n2 = (l2 == null ? 0 : l2.val);
            int sum = n1 + n2 + carry;
            if (sum < 10) {
                carry = 0;
            } else {
                carry = 1;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
    
    public ListNode addTwoListsApproach2(ListNode l1, ListNode l2) {
        // convert two lists into numbers, then convert the sum back to a list
        // doesn't work when the number represented by the list is too big
        if (l1 == null || l2 == null) {
            return null;
        }
        long n1 = 0, n2 = 0;
        int cnt = 0;
        while (l1 != null) {
            n1 += l1.val * Math.pow(10, cnt++);
            l1 = l1.next;
        }
        cnt = 0;
        while (l2 != null) {
            n2 += l2.val * Math.pow(10, cnt++);
            l2 = l2.next;
        }

        ListNode l3 = new ListNode(0);
        ListNode pre = l3;
        ListNode headPre = pre;
        long sum = n1 + n2;
        if (sum == 0) {
            return l3;
        }
        while (sum != 0) {
            l3 = new ListNode((int)(sum%10));
            sum = sum/10;
            pre.next = l3;
            pre = l3;
        }
        return headPre.next;
    }
}

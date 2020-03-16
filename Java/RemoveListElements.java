class RemoveListElements {
    public ListNode removeElementsRecursively(ListNode root, int val) {
        if (root == null) { return root; }
        if (root.val == val) { return removeElements(root.next, val); }
        root.next = removeElements(root.next, val);
        return root;
    } 
    
    public ListNode removeListIterativelyElements(ListNode head, int val) {
        // Time Complexity: O(n)
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            if(head.next == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }
        return head;
    }

    public ListNode removeListElementsIterativelyApproach2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy, node = head;
        while (node != null) {
            if (node.val != val) {
                dummy.next = node;
                dummy = dummy.next;
            }
            node = node.next;
        }
        dummy.next = null;
        return dummyHead.next;
    }
}

class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // Convert a singly linked list where elements are sorted in ascending order
        // to a height balanced BST.
        if (head == null) return null;
        ListNode slow = head, fast = head, prev = null;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) prev.next = null;
        if (head == slow) return root;  // This step is critical
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}

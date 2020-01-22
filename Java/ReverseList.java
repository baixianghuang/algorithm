class ReverseList {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }

    public ListNode reverseList(ListNode head) {
        // Time complexity: O(n)
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode nex = head.next;
        cur.next = null;
        while (nex != null) {
            prev = cur;
            cur = nex;
            nex = nex.next;
            cur.next = prev;
        }
        return cur;
    }

    public ListNode reverseListRecursively(ListNode node) {
        // Time complexity: O(n)
        if (node == null || node.next == null)
            return node;
        ListNode n = reverseListRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return n;
    }
}

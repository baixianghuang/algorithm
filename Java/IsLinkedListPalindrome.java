class IsLinkedListPalindrome {
    public boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, rev = null;
        // use rev to store the half reversed list, fast moves twice faster as slow
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp;
        }
        if (fast != null) {  // increment slow since the middle value is irrelevant in a palindrome if the list is odd
            slow = slow.next;
        }

        // compare two sub lists
        while (slow != null) {
            if (rev.val != slow.val) {
                return false;
            }
            rev = rev.next;
            slow = slow.next;
        }
        return true;
    }
    
    public boolean isLinkedListPalindromeApproach2(ListNode head) {
        // O(n) time and O(n) space
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int j = list.size() - 1;
        for (int i = 0; i < j; i++) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            else {
                j--;
            }
        }
        return true;
    }
}

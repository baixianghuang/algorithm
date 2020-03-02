class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head, tailPre = null;
        ListNode headTemp = head;
        int cnt = 0;
        while (headTemp != null) {
            cnt++;
            headTemp = headTemp.next;
        }
        headTemp = head;

        for (int i = 0; i < (k % cnt); i++) {
            while (tail.next != null) {
                tailPre = tail;
                tail = tail.next;
            }
            tailPre.next = null;
            tail.next = headTemp;
            headTemp = tail;
        }
        return tail;
    }
}

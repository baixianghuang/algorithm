class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        // Remember this math property from Floyd's cycle detection
        // the position fast and slow meet in the loop is p, then
        // distance(p, loop's entry) = distance(start, loop's entry)
        // Intuitively, slow has just finish 1 loop at p, since it travel x steps
        // before enter the loop, we get the equation above
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, temp = head;
        Set<ListNode> inLoopSet = new HashSet<>();
        // Get in the loop, store nodes in the loop to a set, then traverse the
        // list again, the first node that was already in the set is the entry
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                temp = slow;
                inLoopSet.add(slow);
                slow = slow.next;
                while (slow != temp) {
                    inLoopSet.add(slow);
                    slow = slow.next;
                }
                break;
            }
        }
        temp = head;
        while (temp != null) {
            if (inLoopSet.contains(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }
}

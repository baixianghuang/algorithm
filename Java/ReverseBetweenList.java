class ReverseBetweenList {
    public ListNode reverseBetweenList (ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        int cnt = 1;
        ListNode pre = null, cur = head;

        ListNode tmp1 = head, tmp2 = null;
        ListNode subHead = null, subTail = null;
        while (cur != null) {
            if (cnt == m-1) {
                tmp1 = cur;
            }
            else if (cnt == n+1) {
                tmp2 = cur;
            }

            ListNode nex = cur.next;
            if (cnt <= n && cnt >= m) {
                if (cnt == n) {
                    subHead = cur;
                }
                if (cnt == m) {
                    subTail = cur;
                }
                if (m != n) {
                    cur.next = pre;
                }
            }
            pre = cur;
            cur = nex;
            cnt++;
        }
//        System.out.println(subTail.val);
        if (!subTail.equals(tmp1)) {
            tmp1.next = subHead;
            subTail.next = tmp2;
            return head;
        }
        else {
            return subHead;
        }
    }
}

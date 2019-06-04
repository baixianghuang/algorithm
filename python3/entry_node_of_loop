class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def entry_node_of_loop(head):
    """core idea: using two pointers"""
    # judge loop
    p1 = head.next
    p2 = head.next.next
    while p1.val != p2.val:
        p1 = p1.next
        p2 = p2.next.next
    # print('has loop')
    checkpoint_val = p1.val
    p1 = p1.next
    cnt = 1

    # number of nodes in the loop
    while p1.val != checkpoint_val:
        # print(p1.val, checkpoint_val)
        p1 = p1.next
        cnt += 1
    # print(cnt)

    p1 = head
    p2 = head
    # p2 move cnt steps
    for i in range(cnt):
        p2 = p2.next
    while p1.val != p2.val:
        p1 = p1.next
        p2 = p2.next

    print(p1.val)   
    return p1


node_1 = ListNode(1)
node_2 = ListNode(2)
node_3 = ListNode(3)
node_4 = ListNode(4)
node_5 = ListNode(5)
node_1.next = node_2
node_2.next = node_3
node_3.next = node_4
node_4.next = node_5
entry_node_of_loop(node_1)

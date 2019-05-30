class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def find_k_th_to_tail(head_node, k):
    """
    one direction list
    the kth element from tail to head by ONLY traverse the list once
    """
    if head_node == None or k == 0:
        return None
    
    # define 2 pointers
    first = head_node
    second = head_node

    # first pointer move k-1 steps
    for i in range(k-1):
        if first.next != None:
            first = first.next
        else:
            return

    while first.next != None:
        first = first.next
        second = second.next
    return second


node_1 = ListNode(1)
node_2 = ListNode(2)
node_3 = ListNode(3)
node_4 = ListNode(4)
node_5 = ListNode(5)
node_1.next = node_2
node_2.next = node_3
node_3.next = node_4
node_4.next = node_5

node = node_1
while node:
    print(node.val, '->', end='')
    node = node.next
print()

find_k_th_to_tail(node_1, 3)

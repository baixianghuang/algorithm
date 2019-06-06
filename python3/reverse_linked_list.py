class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def reverse_linked_list(head):
    """
    solution 1: create a new linked list (extra space)
    solution 2: use 3 pointers (will mutate the original list)
    return: the head of the reversed list
    """   
    if head == None:
        return None

    # ========== solution 1
    # node = head
    # stack = []
    # while node:
    #     stack.append(node)
    #     node = node.next
    #
    # reversed_head_node = stack.pop()
    # reversed_node = reversed_head_node
    # while len(stack) != 0:
    #     reversed_node.next = stack.pop()
    #     reversed_node = reversed_node.next
    # reversed_node.next = None

    # ========== solution 2
    p_prev = None
    p = head

    while p:
        p_next = p.next
        if p_next == None:
            reversed_head_node = p
        p.next = p_prev
        p_prev = p
        p = p_next

    # test the reversed list
#    t = reversed_head_node
#    while t:
#        print(t.val)
#        t = t.next
    return reversed_head_node


node_1 = ListNode(1)
node_2 = ListNode(2)
node_3 = ListNode(3)
node_4 = ListNode(4)
node_5 = ListNode(5)
node_6 = ListNode(6)
node_1.next = node_2
node_2.next = node_3
node_3.next = node_4
node_4.next = node_5
node_5.next = node_6
print(reverse_linked_list(node_1).val)

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        

def merge_linked_lists_recursively(node1, node2):
    """"merge 2 sorted linked list into a sorted list (ascending)"""
    if node1 == None:
        return node2
    elif node2 == None:
        return node1

    new_head = None
    if node1.val >= node2.val:
        new_head = node2
        new_head.next = merge_linked_lists_recursively(node1, node2.next)
    else:
        new_head = node1
        new_head.next = merge_linked_lists_recursively(node1.next, node2)
    return new_head


def merge_linked_lists(head1, head2):
    """"merge 2 sorted linked list into a sorted list (ascending)"""
    node1 = head1
    node2 = head2
    if node1 == None:
        return head2
    elif node2 == None:
        return head1
    
    if node1.val >= node2.val:
        head_tmp = node2
        node2 = node2.next
    else:
        head_tmp = node1
        node1 = node1.next
    node_tmp = head_tmp
    
    while node1 and node2:
        # print(node1.val, node2.val)
        if node1.val >= node2.val:  # insert node2 after head_new
            node_tmp.next = node2
            node_tmp = node2
            node2 = node2.next
        else:  # insert node1 after head_new
            node_tmp.next = node1
            node_tmp = node1
            node1 = node1.next

    if node1 != None:
        while node1 != None:
            node_tmp.next = node1
            node_tmp = node_tmp.next
            node1 = node1.next
    elif node2 != None:
        while node2 != None:
            node_tmp.next = node2
            node_tmp = node_tmp.next
            node2 = node2.next

    return head_tmp
    
    
# list 1: 1 -> 3 -> 5
# list 2: 2 -> 4 -> 6
node_1 = ListNode(1)
node_2 = ListNode(2)
node_3 = ListNode(3)
node_4 = ListNode(4)
node_5 = ListNode(5)
node_6 = ListNode(6)
node_1.next = node_3
node_3.next = node_5
node_2.next = node_4
node_4.next = node_6

test1 = merge_linked_lists(node_1, node_2)
while test1:
    print(test1.val, " ", end="")
    test1 = test1.next
print()
# test2 = merge_linked_lists_recursively(node_1, node_2)
# while test2:
#     print(test2.val, " ", end="")
#     test2 = test2.next

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def del_node(node):
    """
    delete a node in a linked list
    time complexity restriction: O(1)
    """
    node.val = node.next.val
    node.next = node.next.next


node_1 = ListNode(1)
node_2 = ListNode(2)
node_3 = ListNode(3)
node_4 = ListNode(4)
node_1.next = node_2
node_2.next = node_3
node_3.next = node_4

del_node(node_3)
node = node_1
while node:
    print(node.val)
    node = node.next

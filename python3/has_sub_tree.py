class BinaryTreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def has_sub_tree(root, root_sub):
    if root_sub == None or root == None:
        return False

    if is_sub(root, root_sub):
        return True
    else:
        return is_sub(root.left, root_sub) or is_sub(root_sub.right, root_sub)


def is_sub(node1, node2):
    if node2 == None:
        return True
    if node1 == None:
        return False
    if node1.val != node2.val:
        return False

    return is_sub(node1.left, node2.left) and is_sub(node1.right, node2.right)

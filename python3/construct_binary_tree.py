from queue import Queue


class BinaryTreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def print_binary_tree_bfs(root):
    """use either Queue or list"""
    if not isinstance(root, BinaryTreeNode):
        return
    queue = Queue()
    queue.put(root)

    while not queue.empty():
        node = queue.get()
        print(node.val)
        if node.left != None:
            queue.put(node.left)
        if node.right != None:
            queue.put(node.right)


def construct_binary_tree(preorder, inorder):
    """constructing a tree using given preorder and inorder traverse"""
    if len(preorder) == 0 or preorder == None or inorder == None:
        return None

    val = preorder[0]
    root = BinaryTreeNode(val)

    if len(preorder) > 1:
        inorder_root_index = inorder.index(val)
        inorder_left_sub_tree = inorder[:inorder_root_index]
        inorder_right_sub_tree = inorder[inorder_root_index+1:]
        preorder_left_sub_tree = preorder[1:len(inorder_left_sub_tree)+1]
        preorder_right_sub_tree = preorder[len(inorder_left_sub_tree) + 1:]
        root.left = construct_binary_tree(preorder_left_sub_tree, inorder_left_sub_tree)
        root.right = construct_binary_tree(preorder_right_sub_tree, inorder_right_sub_tree)
    return root


tree_result = construct_binary_tree([1, 2, 4, 7, 3, 5, 6, 8], [4, 7, 2, 1, 5, 3, 8, 6])
print_binary_tree_bfs(tree_result)

class BinaryTreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.father = None


def get_next(node):
    """get the next node of a binary tree's inorder traverse"""
    if node == None: 
        return False
    
    # if the input node is a root that has right sub-tree
    if node.right:
        node = node.right
        while node.left:
            node = node.left
        return node

    # f the input node is a leaf node
    if not node.left and not node.right:
        while node.father:
            if node.father.left == node:
                return node.father
            node = node.father
        return None


root = BinaryTreeNode('a')
node_b = BinaryTreeNode('b')
node_c = BinaryTreeNode('c')
node_d = BinaryTreeNode('d')
node_e = BinaryTreeNode('e')
node_h = BinaryTreeNode('h')
node_i = BinaryTreeNode('i')
root.left = node_b
node_b.father = root
root.right = node_c
node_c.father = root
node_b.left = node_d
node_d.father = node_b
node_b.right = node_e
node_e.father = node_b
node_e.left = node_h
node_h.father = node_e
node_e.right = node_i
node_i.father = node_e

print(get_next(node_h).val)
print(get_next(node_b).val)
print(get_next(node_i).val)

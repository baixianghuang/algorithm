# ==========is_balanced_tree==========
def is_balanced_tree(root):
    """use post-order to avoid multiple traverses"""
    if root == None:
        return
 
    # ========== solution 1: use post-order to reduce redundant traverse
    def tree_depth(root):
        """note: combine the depth (int) with the is balanced boolean value
        more efficient (cutting useless branches by setting them as -1)"""
        if root == None:
            return 0
 
        left = tree_depth(root.left)
        if left == -1:
            return -1
        right = tree_depth(root.right)
        if right == -1:
            return -1
 
        if abs(left - right) > 1:
            return -1
        else:
            return max(left, right) + 1
 
    return tree_depth(root) != -1
 
    # ========== solution 2: return a tuple (bool, int)
    # def helper(node):
    #     if node == None:
    #         return True, 0
    #
    #     l = helper(node.left)
    #     r = helper(node.right)
    #     if l[0] and r[0]:
    #         if abs(l[1] - r[1]) <= 1:
    #             return True, max(l[1], r[1]) + 1
    #     return False, -1
    #
    # return helper(root)[0]
 
    # ========== solution 3, less efficient, traverse some nodes multiple times
    # if root == None:
    #     return True
    # if abs(tree_depth(root.left) - tree_depth(root.right)) > 1:
    #     return False
    # return is_balanced_tree(root.left) and is_balanced_tree(root.right)
 
 
# print(tree_depth(root))  # , tree_depth(node_e)
print(is_balanced_tree(node_c), is_balanced_tree(root))

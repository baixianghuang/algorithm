def tree_depth(root):
    """solution 1: recursively count 1
       solution 2: using dfs to traverse the tree (same as No. 32)
       solution 3: use preorder to traverse (same as No. 34)"""
    if root == None:
        return 0
 
    ls = []
    ls_len = []
    node = root
 
    left = tree_depth(root.left)
    right = tree_depth(root.right)
    return max(left, right) + 1
 
    # def helper(node, ls, ls_len):
    #     if node == None:
    #         return
    #     ls.append(node)
    #     helper(node.left, ls, ls_len)
    #     helper(node.right, ls, ls_len)
    #     # for e in ls:
    #     #     print(e.val, end="")
    #     # print()
    #     ls_len.append(len(ls))
    #     ls.remove(node)
    #
    # helper(node, ls, ls_len)
    # # print(ls_len, max(ls_len))
    # return max(ls_len)
 
 
def tree_depth_dict(root, memo={}):
    """extra space: use a dictionary to avoid counting redundant depth"""
    if root == None:
        memo[root] = 0
    if root in memo:
        return memo[root]
    else:
        left = tree_depth_dict(root.left)
        right = tree_depth_dict(root.right)
        result = max(left, right) + 1
        memo[root] = result
        return memo[root]
 
 
print(tree_depth(root))
 

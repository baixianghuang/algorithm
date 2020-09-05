class IsValidBST {
  public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (!isValidBSTHelper(root.left, root.val, true) ||
                !isValidBSTHelper(root.right, root.val, false)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValidBSTHelper(TreeNode node, int val, boolean isLeftSubTree) {
        // Check if all the nodes from left/right subtree are smaller or larger than the root
        if (node == null) return true;
        if (isLeftSubTree && node.val >= val) return false;
        if (!isLeftSubTree && node.val <= val) return false;
        return isValidBSTHelper(node.left, val, isLeftSubTree) && isValidBSTHelper(node.right, val, isLeftSubTree);
    }

    public boolean isValidBSTApproach2(TreeNode root) {
        // Inorder traversal
        if (root == null || (root.left == null && root.right == null)) return true;
        List<Integer> inorderList = new ArrayList<>();
        isValidBSTApproach2Helper(root, inorderList);
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i + 1) <= inorderList.get(i)) return false;
        }
        return true;
    }

    private void isValidBSTApproach2Helper(TreeNode node, List list) {
        if (node == null) return;
        isValidBSTApproach2Helper(node.left, list);
        list.add(node.val);
        isValidBSTApproach2Helper(node.right, list);
    }

    public boolean isValidBSTApproach3(TreeNode root) {
        // Pass upper and lower boundaries in each recursion
        return isValidBSTApproach3Helper(root, null, null);
    }

    private boolean isValidBSTApproach3Helper(TreeNode node, TreeNode lower, TreeNode upper) {
        if (node == null) return true;
        if ((lower != null && node.val <= lower.val) ||
                (upper != null && node.val >= upper.val)) return false;
        if (!isValidBSTApproach3Helper(node.left, lower, node) ||
                !isValidBSTApproach3Helper(node.right, node, upper)) return false;
        return true;
    }
}

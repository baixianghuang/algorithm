class MinTreeDepth {
    public int minDepthRecursive(TreeNode root) {
        if (root == null) { return 0; }
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

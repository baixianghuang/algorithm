class IsTreeBalanced {
    public boolean isBalancedRecursively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { return true; }
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) { return false; }
        return isBalancedRecursively(root.left) && isBalancedRecursively(root.right);
    }

    public boolean isBalancedIteratively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { return true; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Math.abs(treeDepth(node.left) - treeDepth(node.right)) > 1) { return false; }
            if (node.left != null) { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right); }
        }
        return true;
    }

    // return the depth from root to its furthest leaf
    private int treeDepth(TreeNode root) {
        if (root == null) { return 0; }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}

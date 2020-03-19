class SumOfLeftLeaves {
    public int sumOfLeftLeavesRecursively(TreeNode root) {
        if (root == null) { return 0; }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { sum = root.left.val; }
        return sum + sumOfLeftLeavesRecursively(root.left) + sumOfLeftLeavesRecursively(root.right);
    }

    public int sumOfLeftLeavesIteratively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { return 0; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode parent = null;
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null && parent.left == node) {
                sum += node.val;
            }
            parent = node;
            if (node.right != null) { stack.push(node.right); }
            if (node.left != null) { stack.push(node.left); }
        }
        return sum;
    }
}

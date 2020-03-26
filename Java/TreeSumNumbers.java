class TreeSumNumbers {
    public int sumNumbersRecursively(TreeNode root) {
        return sumNumbersRecursivelyHelper(root, 0);
    }

    private int sumNumbersRecursivelyHelper(TreeNode node, int currentSum) {
        if (node == null) { return 0; }
        if (node.left == null && node.right == null) { return currentSum * 10 + node.val; }
        return sumNumbersRecursivelyHelper(node.left, currentSum * 10 + node.left.val) +
                sumNumbersRecursivelyHelper(node.right, currentSum * 10 + node.right.val);
    }

    public int sumNumbersIteratively(TreeNode root) {
        if (root == null) { return 0; }
        int ans = 0;
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));
        while (!stack.isEmpty()) {
            Pair<TreeNode, String> pair = stack.pop();
            TreeNode node = pair.getKey();
            String numStr = pair.getValue();
            if (node.left == null && node.right == null) { ans += Integer.parseInt(numStr); }
            if (node.right != null) { stack.push(new Pair<>(node.right, numStr + String.valueOf(node.right.val))); }
            if (node.left != null) { stack.push(new Pair<>(node.left, numStr + String.valueOf(node.left.val))); }
        }
        return ans;
    }
}

class IsTreeSymmetric {
    public boolean isSymmetricRecursively(TreeNode root) {
        if (root == null) { return true; }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if ((p == null && q == null)) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
        } else {
            return false;
        }
    }

    public boolean isSymmetricIteratively(TreeNode root) {
        if (root == null) { return true; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) { continue; }
            if (p == null || q == null || p.val != q.val) { return false; }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}

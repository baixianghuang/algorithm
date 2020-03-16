class IsSameTree {
    public boolean isSameTreeRecursively(TreeNode p, TreeNode q) {
        if (p == null && q == null) { return true; }
        if (p == null || q == null || p.val != q.val) { return false; }
        return isSameTreeRecursively(p.left, q.left) && isSameTreeRecursively(p.right, q.right);
    }

    public boolean isSameTreeIteratively(TreeNode p, TreeNode q) {
        if (p == null && q == null) { return true; }
        if (p == null || q == null || p.val != q.val) { return false; }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && ! queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) { return false; }
            if (node1.left != null) { queue1.offer(node1.left); }
            if (node2.left != null) { queue2.offer(node2.left); }
            if (queue1.size() != queue2.size()) { return false; }
            if (node1.right != null) { queue1.offer(node1.right); }
            if (node2.right != null) { queue2.offer(node2.right); }
            if (queue1.size() != queue2.size()) { return false; }
        }
        return true;
    }
}

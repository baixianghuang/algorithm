class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int layerNode = queue.size();
            for (int i = 0; i < layerNode; i++) {
                TreeNode node = queue.poll();
                if (i == layerNode - 1) {ans.add(node.val);}
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
        }
        return ans;
    }
}

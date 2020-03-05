class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;  // when num is odd, traverse from left to right; when it's even, traverse from right to left
        while (!queue.isEmpty()) {
            int layerNode = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < layerNode; i++) {
                TreeNode node = queue.poll();
                if (num % 2 == 1) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            ans.add(temp);
            num++;
        }
        return ans;
    }
}

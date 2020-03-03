class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) { return ans; }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> temp = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                temp.add(node.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderApproach2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<TreeNode> layer = new ArrayList<>();
        if (root == null) { return ans; }

        int nextLayer = 0;
        int toBePrinted = 1;
        layer.add(root);
        while (!layer.isEmpty()) {
            TreeNode node = layer.remove(0);
            temp.add(node.val);
            toBePrinted--;
            if (node.left != null) {
                layer.add(node.left);
                nextLayer++;
            }
            if (node.right != null) {
                layer.add(node.right);
                nextLayer++;
            }

            if (toBePrinted == 0) {
                ans.add(temp);
                temp = new ArrayList<>();
                toBePrinted = nextLayer;
                nextLayer = 0;
            }
        }
        return ans;
    }


}

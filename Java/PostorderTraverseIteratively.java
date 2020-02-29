class PostorderTraverseIteratively {
    private class Command {
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };
    
    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        // using Command and Stack to simulate the underlying process of recursion
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            TreeNode cur = command.node;
            if (command.s.equals("print")) {
                ans.add(cur.val);
            } else {
                stack.push(new Command("print", cur));
                if (cur.right != null) { stack.push(new Command("go", cur.right)); }
                if (cur.left != null) { stack.push(new Command("go", cur.left)); }
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversalIterativelyApproach2(TreeNode root) {
        // pre-order: root->left->right, post-order: left->right->root
        // to convert pre-order into post-order, firstly traverse the tree based on root->right->left, then reverse the result
        List<Integer> ans = new ArrayList<>();
        if(root == null) { return ans; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) { stack.push(node.left); }
            if (node.right != null) { stack.push(node.right); }
        }
        Collections.reverse(ans);
        return ans;
    }
}

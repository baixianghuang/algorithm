class InorderTraverseIteratively {
    /**
     * if s.equals("print"), the command is to add the current node's value
     * if s.equals("go"), the command is to move to its child
     */
    private class Command {
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };
    
    public List<Integer> inorderTraversalIteratively(TreeNode root) {
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
                if (cur.right != null) { stack.push(new Command("go", cur.right)); }
                stack.push(new Command("print", cur));
                if (cur.left != null) { stack.push(new Command("go", cur.left)); }
            }
        }
        return ans;
    }
    
    public List<Integer> inorderTraversalIterativelyApproach2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) { return ans; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }     
}

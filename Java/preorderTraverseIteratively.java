class PreorderTraverseIteratively {
    private class Command {
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };
    
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
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
                if (cur.left != null) { stack.push(new Command("go", cur.left)); }
                stack.push(new Command("print", cur));
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversalIterativelyApproach2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) { return ans; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) { stack.push(node.right); }
            if (node.left != null) { stack.push(node.left); }
        }
        return ans;
    }
}

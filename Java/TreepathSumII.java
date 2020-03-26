class TreepathSumII {
    public List<List<Integer>> pathSumIIBackTracking(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumIIHelper(root, sum, path, ans);
        return ans;
    }

    public void pathSumIIHelper(TreeNode node, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) { return; }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) { ans.add(new ArrayList<>(path)); }
        pathSumIIHelper(node.left, sum - node.val, path, ans);
        pathSumIIHelper(node.right, sum - node.val, path, ans);
        path.remove(path.size() - 1);
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSumIIBackTrackingApproach2(TreeNode root, int sum) {
        if (root == null) { return ans; }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(path));
        }
        pathSumIIBackTrackingApproach2(root.left, sum - root.val);
        pathSumIIBackTrackingApproach2(root.right, sum - root.val);
        path.remove(path.size() - 1);
        return ans;
    }
}

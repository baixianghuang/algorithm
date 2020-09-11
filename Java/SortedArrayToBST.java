class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] leftArr = new int[mid];
        int[] rightArr = new int[nums.length - mid - 1];
        for (int i = 0; i < mid; i++) {
            leftArr[i] = nums[i];
        }
        for (int i = mid + 1, j = 0; i < nums.length; i++) {
            rightArr[j++] = nums[i];
        }
        root.left = sortedArrayToBST(leftArr);
        root.right = sortedArrayToBST(rightArr);
        return root;
    }
}

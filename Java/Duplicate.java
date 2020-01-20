class Duplicate {
    public int duplicate(int[] nums) {
        // return any of duplicate entries (all entries are between 0 to n-1 inclusively)
        // Time complexity restriction: O(n), space complexity restriction: O(1)
        if (nums == null)
            throw new IllegalArgumentException("invalid input");

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == i)
                    ans = i;
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return ans;
    }
}

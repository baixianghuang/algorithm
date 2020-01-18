class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        if (nums.length < 3 || nums == null)
            return ans;

        int minSub = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (Math.abs(nums[i] + nums[l] + nums[r] - target) < minSub) {
                    minSub = Math.abs(nums[i] + nums[l] + nums[r] - target);
                    ans = nums[i] + nums[l] + nums[r];
                }
                if (nums[i] + nums[l] + nums[r] > target)
                    r--;
                else
                    l++;
            }
        }
        return ans;
    }
}

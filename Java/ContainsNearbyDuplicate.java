class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // sliding window. Time complexity: O(n)
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < nums.length; r++) {
            if (set.contains(nums[r])) {
                return true;
            }

            set.add(nums[r]);

            if (set.size() == k+1) {
                set.remove(nums[r-k]);
            }
        }
        return false;
    }
}

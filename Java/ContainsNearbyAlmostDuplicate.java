class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // sliding window and TreeSet (the constrain of t requires the data structure to have order)
        // Time complexity: O(nlogk)
        if (t < 0)
            return false;

        TreeSet<Long> set = new TreeSet<>();
        for (int r = 0; r < nums.length; r++) {
            if (set.ceiling((long)nums[r] - (long)t) != null &&
                    set.ceiling((long)nums[r] - (long)t) <= (long)nums[r] + (long)t) {
                return true;
            }
            set.add((long)nums[r]);
            if (set.size() == k+1) set.remove((long)nums[r-k]);
        }
        return false;
    }
}

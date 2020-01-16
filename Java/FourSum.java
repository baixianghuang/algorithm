class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length < 4)
            return ans;

        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            if (j != 0 && nums[j] == nums[j-1])
                continue;
            for (int k = j+1; k < nums.length; k++) {
                if (k != j+1 && nums[k] == nums[k-1])
                    continue;
                // two pointers l and r point to left and right of the sorted array
                int l = k+1, r = nums.length-1, target2 = target-nums[k]-nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == target2) {
                        List<Integer> temp = Arrays.asList(nums[j], nums[k], nums[l], nums[r]);
//                        temp.sort(null);
//                        if (!ans.contains(temp)) {ans.add(temp);}
                        ans.add(temp);
                        while (l < r && nums[l] == nums[l+1]) {l++;}
                        while (l < r && nums[r] == nums[r-1]) {r--;}
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < target2) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

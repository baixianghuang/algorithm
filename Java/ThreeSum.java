class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Time complexity: O(nlog(n))
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                // two pointers l and r point to left and right of the sorted array
                int l = i+1, r = nums.length-1, target = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l<r && nums[l]==nums[l+1]) {l++;}
                        while (l<r && nums[r]==nums[r-1]) {r--;}
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] < target) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }

        // for (List<Integer> a : ans) {
        //     for (int b : a) {
        //         System.out.print(b+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}

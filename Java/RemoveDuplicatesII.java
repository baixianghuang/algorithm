class RemoveDuplicatesII {
    public int removeDuplicatesII(int[] nums) {
        // Time complexity: O(n)
        int i = 0, j = 0;
        while (j < nums.length) {
            int k = nextIndex(nums, j);
            int len = Math.min(2, k-j);
            for (int a = 0; a < len; a++) {
                nums[i+a] = nums[j];
            }
            i += len;
            j = k;
        }

        // for (int e:nums) {
        //     System.out.print(e+" ");
        // }
        // System.out.println();
        return i;
    }
    
    private int nextIndex(int[] nums, int index) {
        for(int i = index; i < nums.length; i++)
            if(nums[i] != nums[index])
                return i;
        return nums.length;
    }
}

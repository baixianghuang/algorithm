class RemoveDuplicates {
    public int removeDuplicatesApproach1(int[] nums) {
        // doesn't use extra space
        int i = 0, j = 1;  // i is the slow-runner
        while (i < nums.length-1) {
            if (j == nums.length) {break;}
            if (nums[i] == nums[j]) {
                j++;
            }
            else {
                i++;
                nums[i] = nums[j];
            }
        }
//        for (int e:nums) {
//            System.out.print(e+" ");
//        }
//        System.out.println();
        return i+1;
    }
    
    public int removeDuplicatesApproach2(int[] nums) {
        Map <Integer, Integer> dict = new LinkedHashMap<>();
        // store each element as key and its frequency as value
        for (int i = 0; i < nums.length; i++) {
            dict.put(nums[i], 0);
        }
        System.out.println(dict+" ");

        int i = 0;
        for (Integer key : dict.keySet()) {
            nums[i++] = key;
        }

        for (int e:nums) {
            System.out.print(e+" ");
        }
        System.out.println();
        return dict.keySet().size();
    }

}

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0; // move the given val into the right of [0,k)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
        for (int e:nums) {
            System.out.print(e+" ");
        }
        return k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, 3, 2};
        System.out.println(s.removeElement(nums, 3));
    }
}

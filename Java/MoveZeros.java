public class MoveZeros {
    public int[] moveZeros(int[] nums) {
        int k = 0;  // [0, k) are non-zero
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(nums[k] == 0) {  // avoid swap if every element is non-zero
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                k++;
            }
        }
        return nums;
    }
}
    

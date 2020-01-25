public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        // sliding window (2 pointers)
        // Time complexity: O(n)
        int len = nums.length, ans = nums.length+1;
        int l=0;  //, r=-1
        int sum=0;

        for (int r = 0; r < len; r++) {
            sum += nums[r];
            while (sum >= s) {
                ans = Math.min((r-l+1), ans);
                sum -= nums[l++];
            }
        }
        return (ans != len+1) ? ans : 0;
    }
    
    public int minSubArrayLenBruteForce1(int s, int[] nums) {
        // Avoid duplicate computation using an array. Time complexity: O(n^2)
        int ans = Integer.MAX_VALUE, len = nums.length;
        int i, j;
        int[] a = new int[len];
        if (nums.length>0) {  // in case nums[] has 0 element
            a[0] = nums[0];
        }
        for (int k = 1; k < len; k++) {
            a[k] = a[k-1] + nums[k];
        }

        for (i = 0; i < len; i++) {
            for (j = i; j < len; j++) {
                int sum = a[j] - a[i] + nums[i];
                if (sum >= s) {
                    ans = Math.min((j-i+1), ans);
                    break;
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public int minSubArrayLenBruteForce2(int s, int[] nums) {
        // Time Complexity: O(n^2)
        int sum = 0, min = nums.length, len = nums.length;
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i; j < len; j++) {
                sum += nums[j];
                if (i==0 && j == len-1 && sum < s){
                    return 0;
                }
                if ((sum >= s) && ((j-i+1) < min)) {
                    min = (j-i+1);
                }
            }
            sum = 0;
        }
        return min;
    }
}

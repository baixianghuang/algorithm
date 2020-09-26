class CanJump {
    public boolean canJumpDP(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            // check if the j-th index can jump to the i-th index
            for (int j = 0; j < i; j++) {
                if (f[j] && (i - j) <= nums[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }
}

class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
        // Priority queue O(nlogk) time and O(k) space
        // Default order of the priority queue is ascending: tail is the biggest
        if (k > nums.length || nums == null) { throw new IllegalArgumentException(); }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        // Sorting O(nlogn) time
        if (k > nums.length || nums == null) { throw new IllegalArgumentException(); }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        // Using partition
        // O(n) time or O(n^2) time in the worst case
        if (k > nums.length || nums == null) { throw new IllegalArgumentException(); }
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int p = partition(nums, left, right);
            if (k < p) {
                right = p - 1;
            } else if (k > p) {
                left = p + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int left, int right) {
        int pivot = left;
        int k = left;  // a[1...k] < a[pivot]
        for (int i = left + 1; i < right + 1; i++) {
            if (a[i] < a[pivot] && k < right) {
                k++;
                swap(a, k, i);
            }
        }
        swap(a, k, pivot);
        return k;
    }
}

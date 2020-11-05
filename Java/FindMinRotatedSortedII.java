class FindMinRotatedSortedII {
  public int findMinRotatedSortedII(int[] nums) {
    // The sorted array is rotated at some pivot, and it contains duplicates
          if (nums == null || nums.length == 0) return -1;
          if (nums.length == 1) return nums[0];
          int left = 0, right = nums.length - 1;
          while (left < nums.length - 1 && nums[left + 1] == nums[left]) { left++; }
          if (left == nums.length - 1) return nums[left];  // all elements are the same
          if (nums[left] < nums[right]) return nums[left];  // no rotation
          while (left <= right) {
              while (left < nums.length - 1 && nums[left + 1] == nums[left]) { left++; }
              int mid = left + (right - left) / 2;
              if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
              // This line must follow behind the check of mid + 1 because mid may be 0
              if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
              if (nums[left] < nums[mid]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }
          return -1;
      }

}

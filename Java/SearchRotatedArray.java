class SearchRotatedArray {
    public boolean searchRotatedArray(int[] A, int target) {
        // Search in Rotated Sorted Array that has duplicates
        if (A == null || A.length == 0) { return false; }
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left + 1 < right && A[left + 1] == A[left]) { left++; }
            while (right - 1 > left && A[right - 1] == A[right]) { right--; }
            int mid = left + (right - left) / 2;
            if (A[mid] == target) { return true; }
            if (A[left] <= A[mid]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else{
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

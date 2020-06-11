class MultiSort {
    // sort by test scores (array[i][1]) in descending order, if the test scores are the same,
    // sort the student number (array[i][0]) in ascending order.
    public int[][] multiSort(int[][] array) {
        Arrays.sort(array, 0, array.length, (arr1, arr2) -> {
            int minus = arr2[1] - arr1[1];
            if (minus == 0) {
                return arr1[0] - arr2[0];
            } else {
                return minus;
            }
        });
        return array;
    }
}

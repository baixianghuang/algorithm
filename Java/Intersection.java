class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs1 = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        for (int n : nums1) {
            hs1.add(n);
        }
        for (int n : nums2) {
            if (hs1.contains(n)) {
                hs2.add(n);
            }
        }
        
        int[] a = new int[hs2.size()];
        int i = 0;
        for (int n : hs2) {
            a[i++] = n;
        }
//        int[] a = hs2.stream().mapToInt(Number::intValue).toArray();  // slower (6 ms)
        return a;
    }
}

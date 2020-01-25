public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Time Complexity: O(n)
        // Unlike intersection.java
        // Each element in the result should appear as many times as it shows in both arrays.
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                ansList.add(n);
                map.put(n, map.get(n)-1);
                if (map.get(n) == 0) {
                    map.remove(n);
                }
            }
        }
        int[] ans = new int[ansList.size()];
        int i = 0;
        for (int n : ansList) {
            ans[i++] = n;
            System.out.println(n);
        }
        return ans;   
    }
}

class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Time complexity: O(n^2)
        // Space complexity: O(n^2)
        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("invalid argument");
            
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int sum = C[k]+D[l];
                map.put(sum, (map.get(sum) == null) ? 1 : (map.get(sum)+1));
            }
        }

        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(0 - A[i] - B[j])) {
                    cnt += map.get(0 - A[i] - B[j]);
                }
            }
        }
        return cnt;
    }

    public int fourSumCountApproach2(int[] A, int[] B, int[] C, int[] D) {
        // Using 2 maps to store possible values of A[i]+B[j] and C[i]+D[j]
        // Time complexity: O(n^2). Space complexity: O(n^2)
        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("invalid argument");
        HashMap<Integer, Integer> map1 = new HashMap<>();  // store all possible values of A[i]+B[j]
        HashMap<Integer, Integer> map2 = new HashMap<>();  // store all possible values of C[i]+D[j]
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i]+B[j];
                map1.put(sum, (map1.get(sum) == null) ? 1 : (map1.get(sum)+1));
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i]+D[j];
                map2.put(sum, (map2.get(sum) == null) ? 1 : (map2.get(sum)+1));
            }
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(-entry.getKey())) {
                cnt += entry.getValue()*map2.get(-entry.getKey());
            }
        }
        return cnt;
    }
}

class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Override the compare method so that elements in nums are added to PriorityQueue according to their frequency
        // Time complexity: O(nlogk)
        List<Integer> ans = new ArrayList<>();
        if (nums ==  null || k > nums.length || k <= 0) { return ans; }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int e : nums) {
            freqMap.put(e, freqMap.getOrDefault(e,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        // to reduce the tome complexity from O(nlogn) to O(nlogk), keep the number of elements in queue <= k
        for (int key : freqMap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            }
            else if (freqMap.get(key) > freqMap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        for (int i = 0; i < k; i++) {
            ans.add(pq.remove());
        }
        return ans;
    }
    
    public List<Integer> topKFrequentApproach3(int[] nums, int k) {
        // Using sort. Time complexity: O(nlogn)
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums ==  null || k > nums.length || k <= 0) { return ans; }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int e : nums) {
            freqMap.put(e, freqMap.getOrDefault(e,0)+1);
        }

        for(Integer key: freqMap.keySet()) {
            ans.add(key);
        }

        Collections.sort(ans, (a, b) -> {
            if(freqMap.get(a) != freqMap.get(b))
                return freqMap.get(b) - freqMap.get(a);
            return a - b;
        });

        return ans.subList(0, k);
    }
}

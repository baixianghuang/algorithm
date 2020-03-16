class TopKFrequent {
    public List<Integer> topKFrequentPriorityQueue(int[] nums, int k) {
        // override the compare method so that elements in nums are added to PriorityQueue according to their frequency
        // time complexity: O(nlogk)
        List<Integer> ans = new ArrayList<>();
        if (nums ==  null || k > nums.length || k <= 0) { return ans; }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int e : nums) {
            freqMap.put(e, freqMap.getOrDefault(e,0)+1);
        }
        // use the default order (always remove the smallest element)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        // to reduce the time complexity from O(nlogn) to O(nlogk), keep the number of elements in queue <= k
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

    public List<Integer> topKFrequentPriorityQueueApproach2(int[] nums, int k) {
        // a different version with same idea of topKFrequent(). This approach use class FreqPair
        List<Integer> ans = new ArrayList<>();
        if (nums ==  null) { return ans; }
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int e : nums) {
            freqMap.put(e, (freqMap.containsKey(e) ? freqMap.get(e)+1 : 1));
        }

        PriorityQueue<FreqPair> pq = new PriorityQueue<>();
        for (int key : freqMap.keySet()) {
            pq.add(new FreqPair(key, freqMap.get(key)));
        }

        for (int i = 0; i < k; i++) {
            ans.add(pq.remove().e);
        }
        return ans;
    }

    public List<Integer> topKFrequentPriorityQueueApproach3(int[] nums, int k) {
        // O(log(n-k))
        List<Integer> ans = new ArrayList<>();
        if (nums ==  null || k > nums.length || k <= 0) { return ans; }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int e : nums) { freqMap.put(e, freqMap.getOrDefault(e,0)+1); }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        // store the least b elements to pq
        int b = freqMap.size() - k;
        for (int key : freqMap.keySet()) {
            if (freqMap.size() > k) {
                if (pq.size() == b && freqMap.get(key) < freqMap.get(pq.peek())) { pq.poll(); }
                if (pq.size() < b) { pq.offer(key); }
            }
        }
        System.out.println(pq+" "+freqMap);
        for (int e : freqMap.keySet()) {
            if (!pq.contains(e)) {
                ans.add(e);
            }
        }
        return ans;
    }

    public List<Integer> topKFrequentSortingApproach(int[] nums, int k) {
        // Using sort. Time complexity: O(nlogn)
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums ==  null || k > nums.length || k <= 0) { return ans; }
        Map<Integer,Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        ans.addAll(map.keySet());
        ans.sort((a, b) -> map.get(b) - map.get(a));
        return ans.subList(0, k);
    }

    private class FreqPair implements Comparable<FreqPair>{
        public int e, freq;
        public FreqPair(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(FreqPair o) {
            // set high priority to object with lower frequency
            return o.freq - this.freq;
        }
    }
}

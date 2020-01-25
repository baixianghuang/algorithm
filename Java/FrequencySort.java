class FrequencySort {
    public String frequencySort(String s) {
        // use array instead of map is faster
        // bucket sort faster than quick sort in this case
        int max = 0;
        int[] freq = new int[256];
        for(char c : s.toCharArray()) {
            freq[c]++;
            max = Math.max(max, freq[c]);
        }
        String[] bucket = new String[max + 1];
        for(int i = 0 ; i < freq.length; i++) {
            if(freq[i] > 0)
                bucket[freq[i]] = (bucket[freq[i]] == null) ? "" + (char)i : (bucket[freq[i]] + (char)i);
        }
        StringBuilder ans = new StringBuilder();
        for(int i = max; i >= 0; i--) { // create string for each bucket.
            if(bucket[i] != null) {
                for(char ch : bucket[i].toCharArray()) {
                    for(int j = 0; j < i; j++) {
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }
    
    public String frequencySortApproach3(String s) {
        // quick sort
        Map<Character, Integer> map = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c)==null ? 1 : map.get(c)+1);
        }

        int[] order = new int[map.values().size()];
        int j = 0;
        for (int n : map.values()) {
            order[j++] = n;
//            System.out.println(n);
        }
        Arrays.sort(order);

        for (int i = order.length-1; i >= 0; i--) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (order[i] == entry.getValue()) {
                    for (int k = 0; k < order[i]; k++) {
                        ls.add(entry.getKey().toString());
                    }
                    map.put(entry.getKey(),0);
                }
            }
        }
        return String.join("", ls);
    }
}

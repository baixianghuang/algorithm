class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Using quick sort (O(nlog(n))) or bucket sort O(n))
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();  // <String's index, String's frequency>
        if (strs.length == 0)
            return ans;

        for (String s : strs) {
            char[] cArr = s.toCharArray();
            String sortedStr = bucketSort(cArr);
            if (!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList());
            map.get(sortedStr).add(s);
        }
        ans = new ArrayList(map.values());
        return ans;
    }
    
    private String bucketSort(char[] input) {
        int[] bucket = new int[26];
        StringBuilder s = new StringBuilder();
        for (char c : input) {
            bucket[c-'a']++;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                s.append((char)i);
            }
        }
        return s.toString();
    }
    
    public List<List<String>> groupAnagramsApproach2(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();  // <String's index, String's frequency>
        if (strs.length == 0)
            return ans;

        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> temp = new ArrayList<>();
            map.put(i, (map.containsKey(i) ? map.get(i)+1 : 1));
            if (map.get(i) == 1) {
                temp.add(strs[i]);
            }
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isAnagram(strs[i], strs[j])) {
                    map.put(j, (map.containsKey(j) ? map.get(j)+1 : 1));
                    if (map.get(j) == 1) {
                        temp.add(strs[j]);
                    }
                }
            }
            if (temp.size()>=1)
                ans.add(temp);
        }
        return ans;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
         int[] cnt = new int[26];
         for (int i = 0; i < s.length(); i++) {
             cnt[s.charAt(i) - 'a']++;
             cnt[t.charAt(i) - 'a']--;
         }
        for (int n : cnt) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}

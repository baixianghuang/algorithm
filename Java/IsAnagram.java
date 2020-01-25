class IsAnagram {
    public boolean isAnagramApproach2(String s, String t) {
        // using array as counter
        // Time complexity: O(n)
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;  // assume all characters in the strings are lowercase
            cnt[t.charAt(i) - 'a']--;
        }
        for (int n : cnt) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAnagramApproach1(String s, String t) {
        // using HashMap
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char n : sArr) {
            if (map1.containsKey(n)) {
                map1.put(n, map1.get(n) + 1);
            } else {
                map1.put(n, 1);
            }
        }
        for (char n : tArr) {
            if (!map1.containsKey(n)) {
                return false;
            }
            if (map2.containsKey(n)) {
                map2.put(n, map2.get(n) + 1);
            } else {
                map2.put(n, 1);
            }
        }
        for (char n : sArr) {
            if (!map2.containsKey(n)||map2.get(n).intValue() != map1.get(n).intValue()) {
                return false;
            }
        }
        return true;
    }
}

class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // Time Complexity: O(len(p) + len(s))
        // using freq array is much faster than using subString
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        for (char c : pArr) {
            freqP[c-'a']++;
        }

        int l = 0;  // Sliding window: s[l...r]
        for (int r = 0; r < s.length(); r++) {
            freqS[sArr[r]-'a']++;
            if ((r-l+1) > p.length()) {
                freqS[sArr[l]-'a']--;
                l++;
            }
            if ((r-l+1) == p.length() && isAnagram(freqS, freqP)) {
                list.add(l);
            }
        }

//        for (int n:list){
//            System.out.print(n+" ");
//        }
        return list;
    }

    private boolean isAnagram(int[] freq, int[] freqP) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != freqP[i]) {
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> findAnagramsApproach2(String s, String p) {
        // sliding window using substring (may cause low performance?)
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int l = 0, len = s.length();
        for (int r = 0; r <= len; r++) {
//            String temp = s.substring(l, r);
            if (s.substring(l, r).length() >= p.length()) {
                System.out.println(s.substring(l, r));
                if (isAnagram(s.substring(l, r), p)) {
                    list.add(l);
                }
                l++;
            }
        }
        return list;
    }
    
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }
        for (int a : freq) {
            if (a != 0)
                return false;
        }
        return true;
    }
}

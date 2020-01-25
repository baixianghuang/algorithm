public class WordPattern {
    public boolean wordPatternApproach1(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length)
            return false;
        Map map = new HashMap();
        for (int i = 0; i < strArr.length; i++) {
            // put() returns the previous value associated with key
            if (map.put(pattern.charAt(i), i) != map.put(strArr[i], i))
                return false;
        }
        return true;
    }

    public boolean wordPatternApproach2(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length)
            return false;
        // each char in pattern maps to a string in str
        Map<Character, String> map = new HashMap<>();
        Map<String, Integer> mapCnt = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), strArr[i]);
        }
        for (String s : map.values()) {
            mapCnt.put(s, (mapCnt.containsKey(s)) ? mapCnt.get(s)+1 : 1);
        }
        for (int i : mapCnt.values()) {
            if (i > 1)
                return false;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].equals(map.get(pattern.charAt(i))))
                return false;
        }
        return true;
    }
}

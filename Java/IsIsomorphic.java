class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map = new int[256];  // <a char in s, corresponding char in t>
        boolean[] flag = new boolean[256];  // to ensure each new char from s hasn't been mapped yet

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) {
                if (flag[t.charAt(i)])
                    return false;
                map[s.charAt(i)] = t.charAt(i);
                flag[t.charAt(i)] = true;
            }
            else if (map[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

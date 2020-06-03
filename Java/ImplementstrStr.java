class ImplementstrStr{
  public int strStr(String source, String target) {
        // Can't use built-in methods such as indexOf() and substring()
        if (target.isEmpty()) { return 0; }
        for (int i = 0; i <= source.length()- target.length(); i++) {
            for (int j = 0; j < target.length() && target.charAt(j) == source.charAt(j + i); j++) {
                if (j == target.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStrApproach2(String source, String target) {
        return source.indexOf(target);
    }

    public int strStrApproach3(String source, String target) {
        // Bad solution that use built-in substring() O(n^2) time
        if (target.length() == 0) { return 0; }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            if (source.substring(i, i + target.length()).equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
    

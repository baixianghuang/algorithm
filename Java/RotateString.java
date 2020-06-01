class RotateString {
    public boolean rotateString(String A, String B) {
        // The rotation of A is always a substring of A + A
            if (A.length() != B.length()) { return false; }
            return (A + A).contains(B);
    }

    public boolean rotateStringApproach2(String A, String B) {
        // Brute force
        for (int i = 0; i <= A.length(); i++) {
            if (rotateStringHelper(A, i).equals(B)) { return true; }
        }
        return false;
    }

    private String rotateStringHelper(String s, int offset) {
        if (s == null) { return null; }
        if (s == "") { return ""; }
        offset = offset % s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < offset; i++) {
            char rightChar = charArray[charArray.length - 1];
            for (int j = charArray.length - 1; j >= 1; j--) {
                charArray[j] = charArray[j - 1];
            }
            charArray[0] = rightChar;
        }
        return String.valueOf(charArray);
    }
}

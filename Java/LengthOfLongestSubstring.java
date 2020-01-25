class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];  // for ASCII char (1 Byte)
        char [] strArr = s.toCharArray();
        int len = strArr.length, ans = 0;
       int l = 0;

       for (int r = 0; r < len; r++) {
           freq[strArr[r]] += 1;
           while (freq[strArr[r]] > 1) {
               freq[strArr[l]] -= 1;
               l++;
           }
           ans = Math.max((r - l + 1), ans);
       }
       
        return ans;
    }
}

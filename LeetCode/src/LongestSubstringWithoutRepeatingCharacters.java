public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int n = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        String str = "";
        for (Character c : s.toCharArray()) {
            if (str.contains(c.toString())) {
                str = str.substring(str.indexOf(c) + 1);
                str += c;
                maxLength = Math.max(maxLength, str.length());
            } else {
                str += c;
                maxLength = Math.max(maxLength, str.length());
            }
        }
        return maxLength;
    }
}

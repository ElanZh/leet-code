package no5;

public class Solution1 {
    public static void main(String[] args) {
//        System.out.println(new Solution1().longestPalindrome(""));
        System.out.println(new Solution1().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        String max = "";
        int i = 0;
        int sl = s.length();
        while (i < sl - max.length()) {
            int j = sl - 1;
            while (j >= i) {
                String subs = s.substring(i, j + 1);
                if (huiwen(subs)) {
                    if (max.length() < subs.length()) {
                        max = subs;
                    }
                    break;
                }
                --j;
            }
            ++i;
        }
        return max;
    }

    boolean huiwen(String s) {
        int l = s.length();
        int i = 0, j = l - 1;
        int end = l >> 1;
        while (i < end) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}

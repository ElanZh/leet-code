package no3;

import java.util.HashSet;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int result = 1, i = 0;
        do {
            HashSet<Character> set = new HashSet<>();
            int j = i;
            do {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                } else {
                    break;
                }
                if (result < set.size()) {
                    result = set.size();
                }
                j++;
            } while (j < chars.length);
            i++;
        } while (i < chars.length - result + 1);
        return result;
    }
}

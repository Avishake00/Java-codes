package sliding_window.veriable_length;

import java.util.*;

public class min_window_subStrng {

    static String minWindow(String s, String t) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        int startIndex = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                int windowLen = end - start + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = start;
                }

                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }

        if (startIndex == -1) {
            return "";
        } else {
            return s.substring(startIndex, startIndex + minLen);
        }

    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";

        System.out.println(minWindow(s, t));
    }
}

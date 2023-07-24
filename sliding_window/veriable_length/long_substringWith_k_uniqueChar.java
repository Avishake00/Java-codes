package sliding_window.veriable_length;

import java.util.HashMap;

public class long_substringWith_k_uniqueChar {
    static int maxlength(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        int ans = 0;

        while (end < s.length()) {

            // add the characters in map and increment the nonunique char values
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            } else {
                map.put(s.charAt(end), +1);
            }

            // increase window size until hit the base condition that is get k uniqe
            // charecters
            if (map.size() < k) {
                end++;
            }

            // if hit then return the max size
            if (map.size() == k) {
                ans = Math.max(end - start + 1, ans);
                end++;
            }

            // if in map>k uniqe character present then remove from first of window and
            // remove the key from map if the value is=0
            if (map.size() > k) {
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                }
                start++;
                end++;
            }
        }

        if (ans == 0)
            return -1;

        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcdef";
        System.out.println(maxlength(s, 4));
    }

}

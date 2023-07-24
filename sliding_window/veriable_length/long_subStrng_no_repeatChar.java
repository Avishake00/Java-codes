package sliding_window.veriable_length;

import java.util.*;

// can also do this by map 
//put the elements in map
// if map.size==window size then end++;
//if map.size<window size means there is some repeating elemet present so remove s.charAt(start) from map then check again
public class long_subStrng_no_repeatChar {

    static int printmax(String s) {
        HashSet<Character> set = new HashSet<>();
        int end = 0;
        int start = 0;
        int ans = 0;

        while (end < s.length()) {

            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                ans = Math.max(ans, end - start + 1);
                end++;
            }
            // here we cant do if (set.contains(s.charAt(end))) cause "end" already
            // increased in last condition and al conditions are
            // checked every time cause it is a set
            else {
                set.remove(s.charAt(start));
                start++;
                // here no need to do end++ cause we have to just remove the first element cause
                // without that also else part can contains
                // non repeat char
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(printmax(s));
    }
}

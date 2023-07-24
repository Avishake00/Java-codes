package sliding_window.fixed_length;

import java.util.*;

public class no_of_anagram {
    static int anagram(String s, String ptr) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int n = s.length();
        int key = ptr.length();
        int ans = 0;
        int count = ptr.length();

        for (int i = 0; i < ptr.length(); i++) {
            if (!map.containsKey(ptr.charAt(i))) {
                map.put(ptr.charAt(i), 1);
            } else {
                map.put(ptr.charAt(i), map.get(ptr.charAt(i)) + 1);
            }
        }

        while (end < n) {
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                if (map.get(s.charAt(end)) >= 0) // check this line******
                {
                    count--;
                }
            }

            if (end - start + 1 < key) {
                end++;
            } else {
                if (count == 0) {
                    ans++;
                }

                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) > 0) // check this line*****
                    {
                        count++;
                    }
                }

                start++;
                end++;

                // Additional check to handle cases where multiple anagrams are overlapping
                // if window size exceeds the key then we have to remove the first element from
                // the map as well as increament the start
                if (end - start + 1 > key) {
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                        if (map.get(s.charAt(start)) == 0) {
                            count--;
                        }
                    }
                    start++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
        String ptr = "kkkkk";

        System.out.println(anagram(s, ptr));
    }
}

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        outer:
        for (int i = 0; i < s.length(); i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {

                if (set.contains(s.charAt(j))) {
                    continue outer;
                }

                set.add(s.charAt(j));

                max = Math.max(max, set.size());
            }
        }

        return max;
    }
}

package suanfa;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubString(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, left = 0, right = 0;

        while (left < n && right < n) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right = left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;

    }


}

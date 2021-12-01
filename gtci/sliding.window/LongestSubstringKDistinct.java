import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;

        int result = helper(s, k);
        System.out.println(result);
    }

    private static int helper(String s, int k) {

        int result = 0;

        int left = 0, right = 0;
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() <= k) {
                result = Math.max(result, right - left + 1);
            } else {
                while (map.size() >= k) {
                    ch = s.charAt(left);
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) <= 0) {
                        map.remove(ch);
                    }
                    left++;
                }
            }

            right++;
        }

        return result;
    }

}

 

public class Solution{

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Count characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        int required = map.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Try shrinking the window
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (map.containsKey(leftChar) && window.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

     
}

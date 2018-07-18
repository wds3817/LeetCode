package leetcode;


import java.util.HashMap;

/*
 *    for example: a b c a b c
 *
 */


public class theLongestSubstring{
    public int theLongestSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}

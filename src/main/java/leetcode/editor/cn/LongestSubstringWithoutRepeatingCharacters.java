//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String a = "tmmzuxt";
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int maxLen = 0, slow = 0, fast = 0;
            Set<Character> set = new HashSet<>();
            while (slow < n && fast < n) {
                if (!set.contains(s.charAt(fast))) {
                    set.add(s.charAt(fast++));
                    maxLen = Math.max(maxLen, fast - slow);
                } else {
                    set.remove(s.charAt(slow++));
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)



    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
                }
            }
            return ans;
        }

        public boolean allUnique(String s, int l, int r) {
            Set<Character> set = new HashSet<>();
            for (int i = l; i < r; i++) {
                if (set.contains(s.charAt(i))) {
                    return false;
                } else {
                    set.add(s.charAt(i));
                }
            }
            return true;
        }
    }
}
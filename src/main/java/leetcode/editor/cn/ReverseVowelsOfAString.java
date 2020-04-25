//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


package leetcode.editor.cn;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            String vowels = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                char lc = chars[l];
                char rc = chars[r];
                if (!vowels.contains(String.valueOf(lc))) {
                    l++;
                    continue;
                }
                if (!vowels.contains(String.valueOf(rc))) {
                    r--;
                    continue;
                }
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
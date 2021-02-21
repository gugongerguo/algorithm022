/**
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

示例 1：

输入："ab-cd"
输出："dc-ba"
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder res = new StringBuilder();
        int end = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(end))) {
                    end--;
                }
                res.append(S.charAt(end--));
            }else{
                res.append(S.charAt(i));
            }
        }
        return res.toString();
    }
}
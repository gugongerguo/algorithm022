/**
给定一个字符串，逐个翻转字符串中的每个单词。

说明：

无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        List<String> strings = Arrays.asList(split);
        Collections.reverse(strings);
        return String.join(" ",strings);
    }
}
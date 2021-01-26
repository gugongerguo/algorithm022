/**
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
方法一：动态规划理解起来有些晦涩
方法二：括号的问题用入栈出栈的思想比较容易理解
    1.首先入栈下标-1，用与计算长度
    2.如果是（ ，入栈当前下标
    3.如果是 ），则弹出栈顶（ 的下标，
      3.1.栈内还有元素，再计算当前下标与stack.peek的差值即长度，该长度取最大值。
      3.2.栈内空了，把当前 ）的下标入栈，栈底永远只会保留一个-1或者 ）的下标。作为下个有效括号的计数起点
*/
class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    result = Math.max(i-stack.peek(), result);
                }
            }
        }
        return result;
    }
}
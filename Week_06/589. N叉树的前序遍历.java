/**
给定一个 N 叉树，返回其节点值的前序遍历。
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        process(root);
        return result;
    }

    public void process (Node root) {
        if(root==null) return;
        result.add(root.val);
        // 子节点从左到右递归
        for(Node child:root.children){
            process(child);
        }
    }
}
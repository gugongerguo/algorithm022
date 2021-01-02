/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private TreeNode process(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI, Map<Integer, Integer> map) {

        if (startP > endP) return null;
        TreeNode root = new TreeNode(preorder[startP++]);
        Integer inorder_root_index = map.get(root.val);
        int leftLength = inorder_root_index - startI;
        root.left = process(preorder, startP, startP + leftLength - 1, inorder,
                startI, inorder_root_index-1, map);
        root.right = process(preorder, startP + leftLength, endP, inorder,
                inorder_root_index+1, endI, map);
        return root;
    }
}
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
    public int maxDepth(TreeNode root) {
        return dft(root,0);
    }
    public int dft(TreeNode root, int count){
        if(root == null) return count;
        count ++;
        int left = dft(root.left, count);
        int right = dft(root.right, count);
        return Math.max(left, right);
    }
}

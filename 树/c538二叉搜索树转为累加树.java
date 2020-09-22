/*
二叉搜索树的中序遍历是升序数组，反中序遍历就是降序数组
把每个节点值改为右边大于它的值的累加即可
有返回值的递归可以不赋值给变量
*/
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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        convertBST(root.right);//有返回值的递归可以不赋值给变量
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

package OneHundredTop;

/**
 *
 * 226. 翻转二叉树
 *
 *  经典的反转二叉树
 */
public class InvertBinaryTree {
    /**
     * class Solution {
     *     public TreeNode invertTree(TreeNode root) {
     *         if(root == null){  //递归的退出条件
     *             return null;
     *         }
     *         //递归与交换
     *         TreeNode left = invertTree(root.left);
     *         TreeNode right = invertTree(root.right);
     *         root.left = right;
     *         root.right = left;
     *          return root;
     *
     *     }
     * }
     */
}

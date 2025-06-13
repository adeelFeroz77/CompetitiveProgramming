/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = 0;
    public TreeNode solve(int start, int end, int[] preorder, int[] inorder){
        if(start > end){
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = preorder[idx];
        int i = start;
        for( ; i<=end; i++){
            if(inorder[i] == root.val){
                break;
            }
        }
        idx++;
        root.left = solve(start, i-1, preorder, inorder);
        root.right = solve(i+1, end, preorder, inorder);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        idx = 0;  

        return solve(0, n-1, preorder, inorder); 
    }
}
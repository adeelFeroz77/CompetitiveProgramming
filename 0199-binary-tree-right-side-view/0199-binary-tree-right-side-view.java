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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, 1, map);
        List<Integer> ans = new ArrayList<>();
        
        int i = 1;
        while(map.containsKey(i)){
            ans.add(map.get(i));
            i++;
        }

        return ans;
    }

    public void traverse(TreeNode node, int level, Map<Integer, Integer> map){
        if(node == null){
            return;
        }
        map.put(level, node.val);
        traverse(node.left, level+1, map);
        traverse(node.right, level+1, map);
    }
}
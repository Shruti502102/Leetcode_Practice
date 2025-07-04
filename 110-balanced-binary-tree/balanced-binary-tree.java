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
    public boolean isBalanced(TreeNode root) {
        return checkht(root)!=-1;    
    }
    private int checkht(TreeNode node){
        if(node==null){
            return 0;//empty tree has ht 0
        }
        int leftht=checkht(node.left);
        if (leftht==-1)return -1;
        int rightht=checkht(node.right);
        if(rightht==-1)return -1;
        if(Math.abs(leftht-rightht)>1){
            return -1;
        }
        return 1+Math.max(leftht,rightht);
    }
}
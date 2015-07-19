package BalancedBinaryTree;


class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int x){
		val=x;
	}
}

class Solution {
	public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)!=-1){
            return true;
        }else{
            return false;
        }
    }
    
    private int maxDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int L=maxDepth(node.left);
        int R=maxDepth(node.right);
        if(L==-1 || R==-1 || Math.abs(L-R)>1) {
            return -1;
        }
        else{
            return 1+Math.max(L,R);
        }
    }
}

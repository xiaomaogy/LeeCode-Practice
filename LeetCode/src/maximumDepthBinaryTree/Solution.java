package maximumDepthBinaryTree;


class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int x){
		val=x;
	}
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

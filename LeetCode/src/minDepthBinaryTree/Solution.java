package minDepthBinaryTree;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int x){
		val=x;
	}
}

public class Solution {
	public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        if(root.left!=null && root.right!=null ){
            return 1+Math.min(minDepth(root.left), minDepth(root.right));
        }else if(root.left==null){
            return 1+minDepth(root.right);
        }else{
            return 1+minDepth(root.left);
        }
    }
}

class Solution2 {
	public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode rightMostNode=root;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int depth=1;
        TreeNode node;
        while(!queue.isEmpty()){
        	node=queue.poll();
        	if(node.left==null && node.right==null) break;
        	
        	if(node.left!=null) queue.add(node.left);
        	if(node.right!=null) queue.add(node.right);
        	if(node.equals(rightMostNode)){
        		depth++;
        		rightMostNode=(node.right==null)? node.left:node.right;
        	}
        }
        return depth;
        
    }
}



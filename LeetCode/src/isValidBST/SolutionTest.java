package isValidBST;

import java.util.Queue;
import java.util.LinkedList;


public class SolutionTest {
	public static void main(String args[]){
		TreeNode tree=new TreeNode(3);
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(5);
		
		int[] newTree={10,5,15,-1,-1,6,20};
		TreeNode tree2=TreeNode.turnToTree(newTree);
		
		boolean output3=new Solution2().isValidBST(tree);
		
		System.out.println(output3);
		
		//boolean output=new Solution().isValidBST(tree);
		//boolean output2=new Solution().isValidBST(tree2);
		//System.out.println(output);
		//System.out.println(output2);
		
		//System.out.println(a);
		//System.out.println(myQ.poll());
		//tree.printTree(tree);
	}
}

class Solution3{
	
	TreeNode prev;
	public boolean isValidBST(TreeNode root){
		prev=null;
		return isMonIncrea(root);
	}
	
	private boolean isMonIncrea(TreeNode node){
		if(node==null){
			return true;
		}
		
		if(isMonIncrea(node.left)){
			if(prev!=null && prev.val>node.val) return false;
			prev=node;
			
			return isMonIncrea(node.right);
		}else{
			return false;
		}
	}
}

class Solution2{
	public boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		
		if(isValidBSTAux(root.left,null,root.val) && isValidBSTAux(root.right,root.val,null)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isValidBSTAux(TreeNode node,Integer min,Integer max){
		if(node==null){
			return true;
		}
		
		if((min==null || node.val>min ) && (max==null || node.val<max )
				&& isValidBSTAux(node.left,min,max==null? node.val:Math.min(max, node.val)) 
				&& isValidBSTAux(node.right,min==null?node.val:Math.max(min, node.val),max) )
		{
			return true;
		}else{
			return false;
		}
	}
}


class Solution{
	public boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		
		if(isValidBST(root.left) && isValidBST(root.right) && isSubTreeLessThan(root.left,root.val) && isSubTreeMoreThan(root.right,root.val)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSubTreeLessThan(TreeNode node,int val){
		if(node==null){
			return true;
		}
		
		if(isSubTreeLessThan(node.left,val) && isSubTreeLessThan(node.right,val) && node.val<val){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSubTreeMoreThan(TreeNode node,int val){
		if(node==null){
			return true;
		}
		
		if(isSubTreeMoreThan(node.left,val) && isSubTreeMoreThan(node.right,val) && node.val>val){
			return true;
		}else{
			return false;
		}
	}
}

class TreeNode{
	int val;
	int level=1;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}
	
	public static TreeNode turnToTree(int[] input){
		TreeNode[] nodes=new TreeNode[input.length];
		for(int i=0;i<input.length;i++){
			if(input[i]==-1){
				nodes[i]=null;
			}else{
				nodes[i]=new TreeNode(input[i]);
			}
			
		}
		
		for(int i=0;i<input.length;i++){
			if((2*i+1)<input.length){
				nodes[i].left=nodes[2*i+1];
			}
			if((2*i+2)<input.length){
				nodes[i].right=nodes[2*i+2];
			}
			
		}
		
		return nodes[0];
	}
	
	void addNode(int val){
		TreeNode newNode=new TreeNode(val);
		
		if(newNode.val<this.val){
			if(this.left==null){
				this.left=newNode;
				this.left.level=this.level+1;
			}else{
				this.left.addNode(val);
			}
		}else{
			if(this.right==null){
				this.right=newNode;
				this.right.level=this.level+1;
			}else{
				this.right.addNode(val);
			}
			
		}
		
		return;
	}
	
	void printTree(TreeNode root){
		if(root==null){
			return;
		}
		
		//Queue<TreeNode> currentLevel=new Queue();
		Queue<TreeNode> Qc=new LinkedList<>();
		Queue<TreeNode> Qn=new LinkedList<>();
		Qc.add(root);
		while(!Qc.isEmpty()){
			TreeNode u=Qc.poll();
			if(u!=null){
				System.out.print(u.val+" ");
				Qn.add(u.left);
				Qn.add(u.right);
			}
			if(Qc.isEmpty()){
				System.out.println("");
				Queue<TreeNode> temp;
				temp=Qn;
				Qn=Qc;
				Qc=temp;
			}
		}
	}
	
	void printSpace(int n){
		for(int i=0;i<n;i++){
			System.out.print(" ");
		}
	}
	
	
}
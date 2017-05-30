import java.util.*;

public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left=right=null;}
	}
	public boolean isValidBST(TreeNode root) {
		return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
	}
	public boolean helper(TreeNode root, long maxval,long minval){
		if(root==null) return true;
		if(root.val<=minval || root.val>=maxval) return false;
		return (helper(root.left,root.val,minval)&& helper(root.right,maxval,root.val));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
		TreeNode node1 = obj.new TreeNode(6);
		TreeNode node2 = obj.new TreeNode(4);
		TreeNode node3 = obj.new TreeNode(8);
		TreeNode node4 = obj.new TreeNode(3);
		TreeNode node5 = obj.new TreeNode(5);
		TreeNode node6 = obj.new TreeNode(7);
		TreeNode node7 = obj.new TreeNode(9);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		System.out.println(obj.isValidBST(node1));
	}

}

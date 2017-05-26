import java.util.*;

public class LCA {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { 
			 val = x;
			 left = null;
			 right=null;
		 }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null || root==p || root==q) return root;
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		return (left==null?right:right==null?left:root);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCA obj = new LCA();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(3);
		TreeNode node4 = obj.new TreeNode(4);
		TreeNode node5 = obj.new TreeNode(5);
		TreeNode node6 = obj.new TreeNode(6);
		TreeNode node7 = obj.new TreeNode(7);
		TreeNode node8 = obj.new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		TreeNode temp = obj.lowestCommonAncestor(node1, node4, node5);
		System.out.println(temp.val);
	}

}

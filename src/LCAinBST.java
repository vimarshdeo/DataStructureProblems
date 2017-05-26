import java.util.*;

public class LCAinBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left=right=null;}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if((root.val-p.val) * (root.val-q.val) <= 0) return root;
		return lowestCommonAncestor(root.val>p.val?root.left:root.right,p,q);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCAinBST obj = new LCAinBST();
		TreeNode node1  = obj.new TreeNode(6);
		TreeNode node2  = obj.new TreeNode(4);
		node1.left = node2;
		TreeNode node3  = obj.new TreeNode(8);
		node1.right = node3;
		TreeNode node4  = obj.new TreeNode(3);
		node2.left = node4;
		TreeNode node5  = obj.new TreeNode(5);
		node2.right = node5;
		TreeNode node6  = obj.new TreeNode(7);
		node3.left = node6;
		TreeNode node7  = obj.new TreeNode(9);
		node3.right = node7;
		TreeNode res = obj.lowestCommonAncestor(node1, node3, node7);
		System.out.println(res.val);
	}

}

import java.util.*;

public class RightSideViewOfTree {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(res,root,0);
		return res;
	}
	public void helper(List<Integer> list, TreeNode root, int depth){
		if(root==null){
			return;
		}
		if(list.size()==depth){
			list.add(root.val);
		}
		helper(list,root.right,depth+1);
		helper(list,root.left,depth+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RightSideViewOfTree obj = new RightSideViewOfTree();
		TreeNode root = obj.new TreeNode(1);
		TreeNode left = obj.new TreeNode(2);
		TreeNode right = obj.new TreeNode(3);
		TreeNode ll =  obj.new TreeNode(4);
		TreeNode rr = obj.new TreeNode(5);
		root.left = left;
		root.right = right;
		left.left = ll;
		left.right = null;
		right.left = null;
		right.right = rr;
		System.out.println(obj.rightSideView(root));
	}

}

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left=right=null;}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root==null) return res;
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		int size = que.size();
		while(!que.isEmpty()){
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode temp = que.poll();
				list.add(temp.val);
				if(temp.left !=null) que.add(temp.left);
				if(temp.right != null) que.add(temp.right);
			}
			res.add(list);
			size = que.size();
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
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
		List<List<Integer>> res = obj.levelOrder(node1);
		for(List<Integer> list:res){
			
			System.out.println(list.toString());
		}
	}

}

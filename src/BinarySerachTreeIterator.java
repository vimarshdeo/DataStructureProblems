import java.util.*;

public class BinarySerachTreeIterator {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v){
			val = v;
			left=right=null;
		}
	}
	Stack<TreeNode> stk;
	TreeNode root;
	public BinarySerachTreeIterator(TreeNode root) {
		this.root = root;
		stk = new Stack<>();
		TreeNode cur = root;
		while(cur!=null){
			stk.push(cur);
			cur = cur.left;
		}
	}
	public boolean hasNext() {
		return (!stk.isEmpty());
	}
	public int next() {
		TreeNode node = stk.pop();
		TreeNode temp = node;
		if(node.right!=null){
			temp = temp.right;
			while(temp!=null){
				stk.push(temp);
				temp = temp.left;
			}
		}
		return node.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(8);
		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;
		node5.left = node6;
		node5.right = node7;
		BinarySerachTreeIterator obj = new BinarySerachTreeIterator(node1);
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		//System.out.println(obj.next());
	}

}

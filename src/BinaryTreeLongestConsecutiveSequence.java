import java.util.*;

public class BinaryTreeLongestConsecutiveSequence {
	public static class Node{
		int val;
		Node left,right;
		public Node(int val){
			this.val = val;
			left=right=null;
		}
	}
	public int findsequence(Node root){
		if(root==null){
			return 0;
		}
		int res = helper(root,root.val,0);
		return res;
	}
	public int helper(Node node, int expectedval, int curlen){
		if(node ==null) return 0;
		if(node.val==expectedval){
			curlen++;
		}
		else{
			curlen = 1;
		}
		int left = helper(node.left,expectedval+1,curlen);
		int right = helper(node.right,expectedval+1,curlen);
		return Math.max(curlen,Math.max(left, right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLongestConsecutiveSequence obj = new BinaryTreeLongestConsecutiveSequence();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.left = node2;
		node2.right = node3;
		node1.right = node4;
		System.out.println(obj.findsequence(node1));
	}

}

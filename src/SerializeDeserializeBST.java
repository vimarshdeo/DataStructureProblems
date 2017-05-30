import java.util.*;

public class SerializeDeserializeBST {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	private String NN = "X";
	private String separator = ",";
	public String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		helper(root,str);
		return str.toString();
	}
	private void helper(TreeNode root, StringBuilder str){
		if(root==null){
			str.append(NN).append(separator);
		}
		else{
			str.append(root.val).append(separator);
			helper(root.left,str);
			helper(root.right,str);
		}
	}
	public TreeNode deserialize(String data) {
		Deque<String> que = new LinkedList<>();
		que.addAll(Arrays.asList(data.split(separator)));
		return deq(que);
		
	}
	private TreeNode deq(Deque<String> que){
		String temp = que.pollFirst();
		if(temp.equals(NN)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(temp));
		root.left = deq(que);
		root.right = deq(que);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeDeserializeBST obj = new SerializeDeserializeBST();
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
		
		String s = obj.serialize(root);
		System.out.println(s);
		obj.deserialize(s);
	}

}

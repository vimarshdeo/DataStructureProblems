import java.util.*;

public class Codec {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	private String NN="null";
	private String separator = ",";
	public String serialize(TreeNode root){
		StringBuilder str = new StringBuilder();
		helper1(root,str);
		return str.toString();
	}
	public void helper1(TreeNode root, StringBuilder str){
		if(root==null){
			str.append(NN).append(separator);
		}
		else{
			str.append(root.val).append(separator);
			helper1(root.left,str);
			helper1(root.right,str);
		}
	}
	public TreeNode deserialize(String data) {
        Deque<String> deq = new LinkedList<>();
        deq.addAll(Arrays.asList(data.split(",")));
        return helper2(deq);
    }
	public TreeNode helper2(Deque<String> deq){
		String temp = deq.pollFirst();
		if(temp.equals(NN)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(temp));
		root.left = helper2(deq);
		root.right = helper2(deq);
		return root;
	}
	public static void main(String[] args) {
		Codec obj = new Codec();
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

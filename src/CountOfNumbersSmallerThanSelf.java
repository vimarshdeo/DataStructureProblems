import java.util.*;

public class CountOfNumbersSmallerThanSelf {
	public class TreeNode{
		int leftsum,val;
		TreeNode left,right;
		public TreeNode(int val){
			this.val = val;
			leftsum = 0;
			left = right = null;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		if(nums==null || nums.length==0) return new ArrayList<Integer>();
		Integer[] res = new Integer[nums.length];
		TreeNode root =null;
		for(int i=nums.length-1;i>=0;i--){
			root = helper(nums[i],res,i,root,0);
		}
		return Arrays.asList(res);
	}
	public TreeNode helper(int num, Integer[] res, int index, TreeNode root, int preval){
		if(root==null){
			root = new TreeNode(num);
			res[index] = preval;	
		}
		else if(num>=root.val){
			root.right = helper(num, res, index, root.right,preval+root.leftsum+(num>root.val?1:0));
		}
		else{
			root.leftsum++;
			root.left = helper(num,res,index,root.left,preval);
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOfNumbersSmallerThanSelf obj = new CountOfNumbersSmallerThanSelf();
		int[] nums = {1,2,2,4,1,7,3,2};
		List<Integer> res = obj.countSmaller(nums);
		System.out.println(res.toString());
	}

}

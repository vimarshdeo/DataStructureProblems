import java.util.*;
public class MaximumXor {
	public class TrieNode{
		TrieNode[] next;
		public TrieNode(){
			next  = new TrieNode[2];
		}
	}
	public TrieNode build(int[] nums){
		TrieNode root = new TrieNode();
		for(int n:nums){
			TrieNode temp = root;
			for(int i=31;i>=0;i--){
				int curbit = (n>>>i)&1;
				if(temp.next[curbit]==null){
					temp.next[curbit] = new TrieNode();
				}
				temp = temp.next[curbit];
			}
		}
		return root;
	}
	public int findMaximumXOR(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		TrieNode root = build(nums);
		int max = Integer.MIN_VALUE;
		for(int n:nums){
			int sum = 0;
			TrieNode temp = root;
			for(int i=31;i>=0;i--){
				int curbit = (n>>>i)&1;
				if(temp.next[curbit^1]!=null){
					sum += (1<<i);
					temp = temp.next[curbit^1];
				}
				else{
					temp = temp.next[curbit];
				}
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumXor obj = new MaximumXor();
		int[] nums = {3,10,5,25,2,8};
		System.out.println(obj.findMaximumXOR(nums));
	}

}

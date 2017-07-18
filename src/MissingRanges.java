import java.util.*;

public class MissingRanges {
	 public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		 List<String> res = new ArrayList<>();
		 if(nums==null) return res;
		 int left,right;
		 for(int i = 0;i<=nums.length;i++){
			 if(i==0){
				 left = lower;
			 }
			 else{
				 if(nums[i-1]==Integer.MAX_VALUE){
					 break;
				 }
				 else{
					 left = nums[i-1]+1;
				 }
			 }
			 if(i==nums.length){
				 right = upper;
			 }
			 else{
				 if(nums[i]==Integer.MIN_VALUE){
					 continue;
				 }
				 else{
					 right = nums[i]-1;
				 }
			 }
			 helper(res, left, right);
		 }
		 return res;
	 }
	 public void helper(List<String> res,int left, int right){
		 if(left>right) return;
		 if(left==right){
			 res.add(String.valueOf(left));
		 }
		 else{
			 res.add(String.valueOf(left)+"->"+String.valueOf(right));
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingRanges obj = new MissingRanges();
		int[] nums = {0,1,3,50,75};
		List<String> res = obj.findMissingRanges(nums, 0, 99);
		for(String s:res){
			System.out.println(s);
		}
	}

}

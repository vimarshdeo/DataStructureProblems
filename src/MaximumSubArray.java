import java.util.*;

public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE;
		if(nums==null || nums.length==0) return sum;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		sum = dp[0];
		for(int i = 1;i<nums.length;i++){
			dp[i] = nums[i]+(dp[i-1]<0?0:dp[i-1]);
			sum = Math.max(sum, dp[i]);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubArray obj = new MaximumSubArray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(obj.maxSubArray(nums));
	}

}

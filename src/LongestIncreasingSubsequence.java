import java.util.*;

public class LongestIncreasingSubsequence {
	public int longestincreasingsub(int[] nums){
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return 1;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for(int i=1;i<nums.length;i++){
			for(int j = 0;j<i;j++){
				if(nums[j]<nums[i]){
					dp[i] = Math.max(dp[i],1+dp[j]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		return  max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] nums = {1,5,3,4};
		System.out.println(obj.longestincreasingsub(nums));
	}

}

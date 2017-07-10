import java.util.*;

public class LongestIncreasingSubsequenceNlogN {
	public int lengthOfLIS(int[] nums) { 
		if(nums==null || nums.length==0) return 0;
		ArrayList<Integer> dp = new ArrayList<>();
		for(int n: nums){
			if(dp.isEmpty()||dp.get(dp.size()-1)<n){
				dp.add(n);
			}
			else{
				int index = Collections.binarySearch(dp, n);
				dp.set(index<0?-index-1:index, n);
			}
		}
		return dp.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequenceNlogN obj = new LongestIncreasingSubsequenceNlogN();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(obj.lengthOfLIS(nums));
	}

}

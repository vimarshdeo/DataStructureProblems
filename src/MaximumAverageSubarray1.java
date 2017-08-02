import java.util.*;

public class MaximumAverageSubarray1 {
	public double findMaxAverage(int[] nums, int k) {
		if(nums==null || nums.length==0 || k==0 || nums.length<k) return 1.0*Integer.MIN_VALUE;
		int sum = 0;
		double max = 1.0*Integer.MIN_VALUE;
		for(int i=0;i<k;i++){
			sum += nums[i];
		}
		max = Math.max(max,  1.0*sum/k);
		for(int i=k;i<nums.length;i++){
			sum -= nums[i-k];
			sum += nums[i];
			max = Math.max(max,  1.0*sum/k);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumAverageSubarray1 obj = new MaximumAverageSubarray1();
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(obj.findMaxAverage(nums, 4));
	}

}

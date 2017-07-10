import java.util.*;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int imax = nums[0];
		int imin = nums[0];
		int res = imax;
		for(int i=1;i<nums.length;i++){
			if(nums[i]<0){
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			imax = Math.max(imax*nums[i], nums[i]);
			imin = Math.min(nums[i]*imin, nums[i]);
			
			res = Math.max(res, imax);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int[] nums = {-2,3,-2,4};
		System.out.println(obj.maxProduct(nums));
	}

}

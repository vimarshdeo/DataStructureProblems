import java.util.*;

public class ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		if(nums==null || nums.length==0) return res;
		Arrays.fill(res, 1);
		
		for(int i=1;i<nums.length;i++){
			res[i] = res[i-1]*nums[i-1];
		}
		int right = 1;
		for(int j=nums.length-1;j>=0;j--){
			res[j] = res[j]*right;
			right *= nums[j];
		}
		return res;
	}
	public static void main(String[] args) {
		ProductArrayExceptSelf obj = new ProductArrayExceptSelf();
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		int[] res = obj.productExceptSelf(nums);
		System.out.println(Arrays.toString(res));
	}

}

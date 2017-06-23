import java.util.*;

public class missingpositive {
	public static int missingpos(int[] nums){
		if(nums==null || nums.length==0) return 1;
		for(int i=0;i<nums.length;i++){
			while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i+1) return i+1;
		}
		return nums.length+1;
	}
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		missingpositive obj = new missingpositive();
		int[] nums = {1,2,3};
		System.out.println(obj.missingpos(nums));
	}

}

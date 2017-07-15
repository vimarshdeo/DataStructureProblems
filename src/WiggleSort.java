import java.util.*;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		if(nums==null || nums.length==0) return;
		for(int i=0;i<nums.length-1;i++){
			if(i%2==0){
				if(nums[i]>nums[i+1]){
					swap(nums,i,i+1);
				}
			}
			else{
				if(nums[i]<nums[i+1]){
					swap(nums,i,i+1);
				}
			}
		}
		for(int n:nums)
		System.out.println(n);
	}
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSort obj = new WiggleSort();
		int[] nums = {2,1,4,7,5,3};
		obj.wiggleSort(nums);
	}

}

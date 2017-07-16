import java.util.*;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length<=1) return;
		int i;
		for(i=nums.length-1;i>0;i--){
			if(nums[i-1]<nums[i]){
				break;
			}
		}
		if(i!=0){
			for(int j=nums.length-1;j>=i;j--){
				if(nums[j]>nums[i-1]){
					swap(nums,i-1,j);
					break;
				}
			}
		}
		reverse(nums,i,nums.length-1);
	}
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void reverse(int[] nums, int i, int j){
		while(i<j)
			swap(nums,i++,j--);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation obj = new NextPermutation();
		int[] nums = {1,2,3};
		obj.nextPermutation(nums);
		for(int n:nums)
		System.out.println(n);
	}

}

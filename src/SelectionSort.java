import java.util.*;

public class SelectionSort {
	public void selectionsort(int[] nums){
		if(nums==null || nums.length<=1) return;
		for(int i=0;i<nums.length-1;i++){
			int minindex = i;
			for(int j = i+1;j<nums.length;j++){
				if(nums[j]<nums[minindex]){
					minindex = j;
				}
				int temp = nums[minindex];
				nums[minindex] = nums[i];
				nums[i] = temp;
			}
		}
	}
	public static void main(String[] args){
		SelectionSort obj = new SelectionSort();
		int[] nums = {5,7,2,9,1};
		obj.selectionsort(nums);
		for(int num:nums)
		System.out.println(num);
	}
}

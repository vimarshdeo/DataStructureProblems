import java.util.*;

public class BubbleSort {
	public void bubblesort(int[] nums){
		if(nums==null || nums.length<=1) return;
		for(int i=0;i<nums.length-1;i++){
			for(int j = 0;j<nums.length-i-1;j++){
				if(nums[j+1]<nums[j]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort obj = new BubbleSort();
		int[] nums = {7,3,9,1,5};
		obj.bubblesort(nums);
		for(int num:nums){
			System.out.println(num);
		}
	}

}

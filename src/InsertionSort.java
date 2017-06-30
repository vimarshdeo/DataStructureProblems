import java.util.*;

public class InsertionSort {
	public void insertionsort(int[] nums){
		if(nums==null || nums.length<=1) return;
		for(int i=1;i<nums.length;i++){
			int hole = i;
			int value = nums[i];
			while(hole>0  && nums[hole-1]>value){
				nums[hole] = nums[hole-1];
				hole = hole-1;
			}
			nums[hole] = value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort obj = new InsertionSort();
		int[] nums = {5,8,1,7,3,2};
		obj.insertionsort(nums);
		for(int num:nums){
			System.out.println(num);
		}
	}

}

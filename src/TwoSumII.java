import java.util.*;

public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length-1;
		int[] res = new int[2];
		while(left<right){
			if((numbers[left]+numbers[right])==target){
				res[0] = left+1;
				res[1] = right+1;
				break;
			}
			else if((numbers[left]+numbers[right])<target){
				left++;
			}
			else{
				right--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumII obj = new TwoSumII();
		int[] nums = {2, 7, 11, 15};
		int target = 18;
		int[] res = obj.twoSum(nums, target);
		System.out.println(res[0]+"\t"+res[1]);
	}

}

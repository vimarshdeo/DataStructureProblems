import java.util.*;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
		if(nums==null || nums.length==0) return nums;
		Stack<Integer> stk = new Stack<>();
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		for(int i=0;i<nums.length*2;i++){
			int num = nums[i%nums.length];
			while(!stk.isEmpty() && nums[stk.peek()]<num){
				res[stk.pop()] = num;
			}
			if(i<nums.length) stk.push(i);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreaterElement2 obj = new NextGreaterElement2();
		int[] nums = {1,2,1};
		int[] res = obj.nextGreaterElements(nums);
		for(int i:res){
			System.out.println(i);
		}
	}

}

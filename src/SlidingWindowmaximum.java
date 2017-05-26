import java.util.*;

public class SlidingWindowmaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null || nums.length==0 || nums.length<k) return new int[0];
		int[] res = new int[nums.length-k+1];
		int count=0;
		Deque<Integer> que = new ArrayDeque<>();
		for(int i=0;i<nums.length;i++){
			while(!que.isEmpty() && que.peek()<i-k+1){
				que.poll();
			}
			while(!que.isEmpty() && nums[que.peekLast()]<nums[i]){
				que.pollLast();
			}
			que.offer(i);
			if(i>=k-1){
				res[count++] = nums[que.peek()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowmaximum obj = new SlidingWindowmaximum();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = obj.maxSlidingWindow(nums, k);
		for(int i:res){
			System.out.println(i);
		}
	}

}

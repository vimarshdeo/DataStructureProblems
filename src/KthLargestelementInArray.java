import java.util.*;

public class KthLargestelementInArray {
	public int findKthLargest(int[] nums, int k) {
		if(nums==null ||nums.length==0 || k>nums.length) return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int num:nums){
			pq.offer(num);
			if(pq.size()>k){
				pq.poll();	
			}
		}
		return pq.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestelementInArray obj = new KthLargestelementInArray();
		int[] nums = {3,2,1,5,6,4};
		int k=2;
		System.out.println(obj.findKthLargest(nums, k));
	}

}

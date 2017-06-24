import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int max = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int n:nums){
			if(!map.containsKey(n)){
				int left = (map.containsKey(n-1)?map.get(n-1):0);
				int right = (map.containsKey(n+1)?map.get(n+1):0);
				
				int len = left+right+1;
				map.put(n, len);
				max = Math.max(max, len);
				
				map.put(n-left, len);
				map.put(n+right, len);
			}
			else{
				continue;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int[] nums = {100,1,3,9,2,0};
		System.out.println(obj.longestConsecutive(nums));
	}

}

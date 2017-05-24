import java.util.*;
public class Twosum {
	public static int[] twoSum(int[] nums, int target) {
		if(nums.length==0) return new int[0];
		int[] res = new int[2];
 		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
				res[0] = map.get(target-nums[i]);
				res[1] = i;
				break;
			}
			else{
				map.put(nums[i],i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] res = new int[2];
		res = twoSum(nums,6);
		for(int i:res){
			System.out.println(i);
		}
	}

}

import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0&& nums[i]!=nums[i-1])){
                int temp = 0-nums[i];
                int low = i+1;
                int high=nums.length-1;
                while(low<high){
                    if(nums[low]+nums[high]==temp){
                       
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<temp){
                        low++;
                    }
                    else
                        high--;
                }
            }
        }
        return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum obj = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = obj.threeSum(nums);
		for(List<Integer> list:res){
			System.out.println("New List:");
			
				System.out.println(list.toString());
			
		}
	}

}

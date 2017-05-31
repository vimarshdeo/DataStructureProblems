import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, new ArrayList<Integer>(),nums,0);
		return list;
	}
	private void helper(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, int start){
		list.add(new ArrayList<>(temp));
		for(int i = start;i<nums.length;i++){
			temp.add(nums[i]);
			helper(list,temp,nums,i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets obj = new Subsets();
		int[] nums = {1,2,3};
		List<List<Integer>> list = obj.subsets(nums);
		for(List<Integer> temp:list){
			System.out.println(temp.toString());
		}
 	}

}

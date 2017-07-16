import java.util.*;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		if(nums.length==1){
			res.add(String.valueOf(nums[0]));
			return res;
		}
		for(int i=0;i<nums.length;i++){
			int a  = nums[i];
			while((i+1)<nums.length && (nums[i+1]-nums[i])==1) i++;
			if(nums[i]!=a){
				res.add(String.valueOf(a)+"->"+String.valueOf(nums[i]));
			}
			else{
				res.add(String.valueOf(nums[i]));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges obj = new SummaryRanges();
		int[] nums = {0,1,2,4,5,7};
		List<String> res = obj.summaryRanges(nums);
		for(String s:res){
			System.out.println(s);
		}
	}

}

import java.util.*;

public class ThirdMaximum {
	public int thirdMax(int[] nums) {
		Integer max1, max2, max3;
		max1 = max2 = max3 = null;
		for(Integer n : nums){
		    if(n.equals(max1)|| n.equals(max2) || n.equals(max3)) continue;
			if(max1==null || n>max1){
			    max3 = max2;
			    max2 = max1;
			    max1 = n;
			} 
			else if(max2==null || n>max2){
			    max3 = max2;
			    max2 = n;
			} 
			else if(max3==null || n>max3){
			    max3 = n;
			} 
		}
		return max3!=null?max3:max1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaximum obj = new ThirdMaximum();
		int[] nums = {3,2,1};
		System.out.println(obj.thirdMax(nums));
	}

}

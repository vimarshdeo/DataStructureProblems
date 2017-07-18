import java.util.*;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits==null || digits.length==0) return digits;
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		int carry = 1;
		for(int i = digits.length-1;i>=0;i--){
			sum  = digits[i]+carry;
			carry = sum/10;
			sum = sum%10;
			list.add(0,sum);
		}
		if(carry==1){
			list.add(0, 1);
		}
		int[] res = new int[list.size()];
		for(int i=0;i<list.size();i++){
			res[i] = list.get(i);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne obj = new PlusOne();
		int[] nums = {9,9,9,9,9};
		int[] res = obj.plusOne(nums);
		for(int i:res){
			System.out.println(i);
		}
	}

}

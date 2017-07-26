import java.util.*;

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] result = new int[nums.length];
		int i = 0;
		int j = nums.length-1;
		int index = a>=0?nums.length-1:0;
		while(i<=j){
			if(a>=0){
				result[index--] = quad(nums[i],a,b,c)>quad(nums[j],a,b,c)?quad(nums[i++],a,b,c):quad(nums[j--],a,b,c);
            }
            else{
                result[index++] = quad(nums[i],a,b,c)>quad(nums[j],a,b,c)?quad(nums[j--],a,b,c):quad(nums[i++],a,b,c);
            }
        }
        return result;
    }
    
    public int quad(int x, int a, int b, int c){
        return (a*x*x)+(b*x)+c;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTransformedArray obj = new SortTransformedArray();
		int[] nums = {-4,-2,2,4};
		int[] res = obj.sortTransformedArray(nums, 1, 3, 5);
		for(int n:res)
		System.out.println(n);
	}

}

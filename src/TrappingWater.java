import java.util.*;

public class TrappingWater {
	public int trap(int[] A){
		if(A==null || A.length==0) return 0;
		int left = 0;
		int right = A.length-1;
		int leftmax = Integer.MIN_VALUE;
		int rightmax = Integer.MIN_VALUE;
		int total = 0;
		while(left<right){
			leftmax = Math.max(leftmax, A[left]);
			rightmax = Math.max(rightmax, A[right]);
			if(leftmax<rightmax){
				total += leftmax - A[left];
				left++;
			}
			else{
				total += rightmax - A[right];
				right--;
			}
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingWater obj = new TrappingWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(A));
	}

}

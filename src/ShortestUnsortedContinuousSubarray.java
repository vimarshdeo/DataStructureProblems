import java.util.*;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] A) {
		if(A==null || A.length==0) return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int start = -1;
		int end = -2;
		for(int i=0;i<A.length;i++){
			max = Math.max(max, A[i]);
			min = Math.min(min, A[A.length-1-i]);
			if(max>A[i]) end = i;
			if(min<A[A.length-1-i]) start = A.length-1-i;
		}
		return end-start+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestUnsortedContinuousSubarray obj = new ShortestUnsortedContinuousSubarray();
		int[] A = {2,6,4,8,10,9,15};
		System.out.println(obj.findUnsortedSubarray(A));
	}

}

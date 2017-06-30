import java.util.*;

public class MedianOf2SortedArrays {
	public static double findmedian(int[] nums1,int[] nums2){
		int l1 = nums1.length;
		int l2 = nums2.length;
		if(l1>l2) return findmedian(nums2, nums1);
		int minindex,maxindex, i, j, left_max,right_min;
		minindex = i = j = left_max = right_min = 0;
		maxindex = l1;
		int total = (l1+l2+1)>>1;
		while(minindex<maxindex){
			i = (minindex+maxindex)>>1;
			j = total - i;
			if(i>0 && j<l2 && nums1[i-1]>nums2[j]){
				maxindex = i-1;
			}
			else if(i<l1 && j>0 && nums2[j-1]>nums1[i]){
				minindex = i+1;
			}
			else{
				if(i==0) left_max = nums2[j-1];
				else if(j==0) left_max = nums1[i-1];
				else left_max = Math.max(nums1[i-1], nums2[j-1]);
				
				if((l1+l2)%2==1) return left_max;
				
				if(i==l1) right_min = nums2[j];
				if(j==l2) right_min = nums1[i];
				else right_min = Math.min(nums1[i], nums2[j]);
				
				return (left_max+right_min)/2.0;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOf2SortedArrays obj = new MedianOf2SortedArrays();
		int[] nums1 = {3,6,9};
		int[] nums2 = {1,2,5,7,9};
		System.out.println(obj.findmedian(nums1, nums2));
	}

}

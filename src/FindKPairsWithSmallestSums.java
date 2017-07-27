import java.util.*;

public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0 || k==0) return res;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
		for(int i=0;i<nums1.length;i++){
			pq.add(new int[]{nums1[i],nums2[0],0});
		}
		while(k!=0 && !pq.isEmpty()){
			int[] temp = pq.poll();
			res.add(new int[]{temp[0],temp[1]});
			k--;
			if(temp[2]==nums2.length-1) continue;
			pq.add(new int[]{temp[0],nums2[temp[2]+1],temp[2]+1});	
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKPairsWithSmallestSums obj = new FindKPairsWithSmallestSums();
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		List<int[]> res = obj.kSmallestPairs(nums1, nums2, 3);
		for(int[] n:res){
			System.out.println(n[0]+" "+n[1]);
		}
	}

}

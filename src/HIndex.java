import java.util.*;

public class HIndex {
	public int hIndex(int[] citations) {
		if(citations==null || citations.length==0) return 0;
		Arrays.sort(citations);
		int i=0;
		while(i<citations.length && citations[citations.length-1-i]>i){
			System.out.println("citations[citations.length-1-i] = "+citations[citations.length-1-i]);
			System.out.println("i: "+i);
			i++;
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HIndex obj = new HIndex();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(obj.hIndex(citations));
	}

}

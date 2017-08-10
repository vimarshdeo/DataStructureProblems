import java.util.*;

public class RearrangeStringKDistanceApart {
	public String rearrangeString(String str, int k) {
		if(str==null || str.length()==0) return str;
		int len = str.length();
		int[] count = new int[26];
		int[] validindex = new int[26];
		for(int i=0;i<len;i++){
			count[str.charAt(i)-'a']+=1;
		}
		StringBuilder s = new StringBuilder();
		for(int index = 0;index<len;index++){
			int maxindex = findmaxindex(str,count,validindex,index);
			if(maxindex==-1) return "";
			count[maxindex]--;
			validindex[maxindex] = index+k;
			s.append((char)(maxindex+'a'));
		}
		return s.toString();
	}
	public int findmaxindex(String str,int[] count, int[] valid, int index){
		int max = Integer.MIN_VALUE;
		int maxindex = -1;
		for(int i=0;i<count.length;i++){
			if(count[i]>0 && count[i]>max && index>=valid[i]){
				max = count[i];
				maxindex = i;
			}
		}
		return maxindex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeStringKDistanceApart obj = new RearrangeStringKDistanceApart();
		System.out.println(obj.rearrangeString("aaabbbcce", 3));
	}

}

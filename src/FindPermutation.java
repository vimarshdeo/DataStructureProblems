import java.util.*;
//exmple - DDIIII (D - decreasing, i  - increasing)
public class FindPermutation {
	public int[] findPermutation(String s) {
		int[] res = new int[s.length()+1];
		if(s==null || s.length()==0) return res;
		for(int i=0;i<res.length;i++){
			res[i] = i+1;
		}
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='D'){
				int begin = i;
				while(i<s.length() && s.charAt(i)=='D'){
					i++;
				}
				reverse(res,begin,i);
			}
		}
		return res;
	}
	
	public void reverse(int[] res,int i, int j){
		while(i<j){
			int temp = res[i];
			res[i++] = res[j];
			res[j--] =temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPermutation obj = new FindPermutation();
		int[] res = obj.findPermutation("DDIIIID");
		for(int i:res)
			System.out.println(i);
	}

}

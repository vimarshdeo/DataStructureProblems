import java.util.*;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(t.length()>s.length()||t==null||s==null) return null;
		int begin,end;
		begin = end = 0;
		int minlen = Integer.MAX_VALUE;
		int start = -1;
		int[] tofind = new int[128];
		Arrays.fill(tofind, 0);
		int[] found = new int[128];
		Arrays.fill(found, 0);
		for(int i=0;i<t.length();i++){
			tofind[t.charAt(i)] += 1;
		}
		int count = 0;
		while(end<s.length()){
			if(tofind[s.charAt(end)]==0){
				end++;
				continue;
			}
			found[s.charAt(end)]++;
			if(found[s.charAt(end)]<=tofind[s.charAt(end)])
			count++;
			if(count==t.length()){
				while(found[s.charAt(begin)]==0 || found[s.charAt(begin)]>tofind[s.charAt(begin)]){
					if(found[s.charAt(begin)]>tofind[s.charAt(begin)]) found[s.charAt(begin)]--;
					begin++;
				}
				if(end-begin+1<minlen){
					minlen = end-begin+1;
					start = begin;
				}
			}
			end++;
		}
		StringBuilder str = new StringBuilder();
		for(int i=start;i<start+minlen;i++){
			str.append(s.charAt(i));
		}
		return str.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

}

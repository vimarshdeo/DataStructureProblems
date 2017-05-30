import java.util.*;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0) return 0;
		HashSet<Character> set = new HashSet<>();
		int i,j,max;
		max = Integer.MIN_VALUE;
		i=j=0;
		while(j<s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			}
			else{
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Vimaarsh";
		LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
		System.out.println(obj.lengthOfLongestSubstring(s));
	}

}

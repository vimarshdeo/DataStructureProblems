import java.util.*;

public class MaxSubstringWithAtMostKDistinct {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s==null||s.length()==0||s.length()<k) return 0;
		HashMap<Character,Integer> map = new HashMap<>();
		int maxlen = 0;
		int left = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
			while(map.size()>k){
				map.put(s.charAt(left), map.get(s.charAt(left))-1);
				if(map.get(s.charAt(left))==0){
					map.remove(s.charAt(left));
				}
				left++;
			}
			maxlen = Math.max(maxlen, i-left+1);
		}
		return maxlen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSubstringWithAtMostKDistinct obj = new MaxSubstringWithAtMostKDistinct();
		System.out.println(obj.lengthOfLongestSubstringKDistinct("Vimmarsh", 4));
	}

}

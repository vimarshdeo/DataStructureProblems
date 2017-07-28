import java.util.*;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if(s==null ||s.length()==0) return 0;
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
		}
		int evenlength = 0;
		int oddlength = 0;
		int flag = 0;
		for(char c: map.keySet()){
			if(map.get(c)%2==0){
				evenlength += map.get(c);
			}
			else{
				oddlength += map.get(c)-1;
				flag = 1;
			}
		}
		return evenlength+oddlength+flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome obj = new LongestPalindrome();
		System.out.println(obj.longestPalindrome("aaeerrttuin"));
	}

}

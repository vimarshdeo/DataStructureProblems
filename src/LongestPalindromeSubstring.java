import java.util.*;

public class LongestPalindromeSubstring {
	private int maxlen = 0;
	private int low = 0;
	public String longestPalindrome(String s) {
		if(s.length()<2 || s==null) return s;
		for(int i=0;i<s.length();i++){
			extendpalindromecheck(s,i,i);//in case of odd length
			extendpalindromecheck(s,i,i+1);//in case of even length
		}
		return s.substring(low, low+maxlen);
	}
	public void extendpalindromecheck(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		if(maxlen<right-left-1){
			low = left+1;
			maxlen = right-left-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		LongestPalindromeSubstring obj = new LongestPalindromeSubstring();
		System.out.println(obj.longestPalindrome(s));
	}

}

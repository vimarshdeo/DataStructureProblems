import java.util.*;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int j = 0;
		for(int i = s.length()-1;i>=0;i--){
			if(s.charAt(i)==s.charAt(j)) j++;
		}
		if(j==s.length()) return s;
		String suffix = s.substring(j);
		return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j))+suffix;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPalindrome obj = new ShortestPalindrome();
		String s = "abcd";
		System.out.println(obj.shortestPalindrome(s));
	}

}

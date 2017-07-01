import java.util.*;
public class LongestPrefixLeetcode {
	public int prefixlength(String s){
		if(s==null) return 0;
		if(s.length()<=1) return s.length();
		int len = 1;
		for(int i=1;i<s.length();i++){
			int next = s.charAt(i)-'a';
			int pre = s.charAt(i-1)-'a';
			if(next>=pre) len++;
			else break;
		}
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPrefixLeetcode obj = new LongestPrefixLeetcode();
		String s = "abcdasd";
		System.out.println(obj.prefixlength(s));
	}

}

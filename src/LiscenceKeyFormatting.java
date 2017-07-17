import java.util.*;

public class LiscenceKeyFormatting {
	public String licenseKeyFormatting(String s, int k) {
		if(s==null || s.length()==0) return s;
		StringBuilder str = new StringBuilder();
		for(int i = s.length()-1;i>=0;i--){
			if(s.charAt(i)!='-')
			str.append((str.length()%(k+1))==k?"-":"").append(s.charAt(i));
		}
		return str.reverse().toString().toUpperCase();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LiscenceKeyFormatting obj = new LiscenceKeyFormatting();
		String s  = "2-4A0r7-4k";
		System.out.println(obj.licenseKeyFormatting(s, 4));
	}

}

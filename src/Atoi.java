import java.util.*;

public class Atoi {
	public int myAtoi(String str) {
		str.trim();
		if(str.length()==0 || str==null) return 0;
		int sign =1;
		int start = 0;
		if(str.charAt(0)== '+'|| str.charAt(0)=='-'){
			sign = (str.charAt(0)=='-'?-1:1);
			start++;
		}
		int res = 0;
		for(int i=start;i<str.length();i++){
			if((res>Integer.MAX_VALUE/10) || (res==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>Integer.MAX_VALUE%10)){
				res = (sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE);
				return res;
			}
			res *= 10;
			res += str.charAt(i)-'0';
		}
		return res*sign;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atoi obj = new Atoi();
		System.out.println(obj.myAtoi("123456456363"));
	}

}

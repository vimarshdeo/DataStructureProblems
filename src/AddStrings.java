import java.util.*;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		if((num1==null || num1.length()==0)&&(num2==null || num2.length()==0)) return null;
		if(num1==null || num1.length()==0) return num2;
		if(num2==null || num2.length()==0) return num1;
		StringBuilder str = new StringBuilder();
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		while(i>=0 || j>=0 || carry!=0){
			int sum = (i>=0?num1.charAt(i--)-'0':0) + (j>=0?num2.charAt(j--)-'0':0) + carry;
			str.append(sum%10);
			carry = sum/10;
		}
		return str.reverse().toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings obj = new AddStrings();
		System.out.println(obj.addStrings("999", "110"));
	}

}

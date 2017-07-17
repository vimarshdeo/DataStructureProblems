import java.util.*;

public class BasicCalculator {
	public int calculate(String s) {
		if(s==null || s.length()==0) return 0;
		int result = 0, sign = 1;
		Stack<Integer> stk = new Stack<>();
		int len = s.length();
		for(int i = 0;i<len;i++){
			if(Character.isDigit(s.charAt(i))){
				int temp = s.charAt(i)-'0';
				while((i+1)<len && Character.isDigit(s.charAt(i+1))){
					temp *= 10;
					temp += s.charAt(i+1)-'0';
					i++;
				}
				result += temp*sign;
			}
			else if(s.charAt(i)== '+'){
				sign = 1;
			}
			else if(s.charAt(i)=='-'){
				sign  = -1;
			}
			else if(s.charAt(i)=='('){
				stk.push(result);
				stk.push(sign);
				result = 0;
				sign = 1;
			}
			else if(s.charAt(i)==')'){
				result = (result*stk.pop())+stk.pop();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator obj = new BasicCalculator();
		System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}

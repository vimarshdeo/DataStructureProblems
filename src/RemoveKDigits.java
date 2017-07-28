import java.util.*;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if(num==null || num.length()==0) return "0";
		if(num.length()==k) return "0";
		Stack<Character> stk = new Stack<>();
		int i=0;
		while(i<num.length()){
			while(k!=0 && !stk.isEmpty() && stk.peek()>num.charAt(i)){
				stk.pop();
				k--;
			}
			stk.push(num.charAt(i++));
		}
		while(k>0){
			stk.pop();
			k--;
		}
		StringBuilder str  = new StringBuilder();
		while(!stk.isEmpty()){
			str.append(stk.pop());
		}
		str.reverse();
		while(str.length()>1 && str.charAt(0)=='0'){
			str.deleteCharAt(0);
		}
		return str.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKDigits obj = new RemoveKDigits();
		System.out.println(obj.removeKdigits("11322334465", 3));
	}

}

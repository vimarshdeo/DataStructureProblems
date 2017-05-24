import java.util.*;
public class ValidParanthesis {
	public static boolean isValid(String s) {
		if(s.length()==0 || s==null) return true;
		Stack<Character> stk = new Stack<>();
		for(int i=0;i<s.length();i++){
			char temp = s.charAt(i);
			switch(temp){
				case '{':
				case '(':
				case '[': stk.push(temp);
						break;
				case '}': if(stk.isEmpty() || stk.pop()!='{') return false;
						break;
				case ')': if(stk.isEmpty() || stk.pop()!='(') return false;
						break;
				case ']': if(stk.isEmpty() || stk.pop()!='[') return false;
						break;
				default: return false;
			}
		}
		return stk.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[]{()";
		System.out.println(isValid(s));
	}

}

import java.util.*;

public class ParenthesisBalanceWithSmiley {
	public boolean balanced(String s){
		if(s==null || s.length()==0) return true;
		Stack<Character> stk = new Stack<>();
		int sad=0, happy=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				if(i!=0 && s.charAt(i-1)==':'){
					sad++;
				}else{
					if(stk.isEmpty()) happy = 0;
					stk.push(s.charAt(i));
				}
			}
			else if(s.charAt(i)==')'){
				if(i!=0 && s.charAt(i-1)==':'){
					happy++;
				}
				else{
					if(stk.isEmpty() && sad>0){
						sad--;
					}
					else if(!stk.isEmpty()){
						stk.pop();
					}
					else{
						return false;
					}
				}
			}
		}
		if(!stk.isEmpty() && happy==stk.size()){
			return true;
		}
		return stk.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParenthesisBalanceWithSmiley obj = new ParenthesisBalanceWithSmiley();
		System.out.println(obj.balanced(":(()))"));
	}

}

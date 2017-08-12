import java.util.*;

public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
		if(s==null || s.length()==0) return 0;
		int left=0;
		int right=0;
		int maxlen = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				left++;
			}
			else{
				right++;
			}
			if(left==right){
				maxlen = Math.max(maxlen, right*2);
			}
			else if(right>left){
				left=0;
				right=0;
			}
		}
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i)=='('){
				left++;
			}
			else{
				right++;
			}
			if(left==right){
				maxlen = Math.max(maxlen, left*2);
			}
			else if(left>right){
				left=0;
				right=0;
			}
		}
		return maxlen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParanthesis obj = new LongestValidParanthesis();
		System.out.println(obj.longestValidParentheses(")()())"));
	}

}

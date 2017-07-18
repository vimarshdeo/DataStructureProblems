import java.util.*;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		if(s==null || s.length()==0) return s;
		Stack<Character> stk = new Stack<>();
		int[] count = new int[26];
		boolean[] exist = new boolean[26];
		char[] arr = s.toCharArray();
		for(char c:arr){
			count[c-'a']++;
		}
		for(char c:arr){
			int index = c - 'a';
			count[index]--;
			if(exist[index]) continue;
			while(!stk.isEmpty()&&c<stk.peek()&&count[stk.peek()-'a']!=0){
				exist[stk.pop()-'a'] = false;
			}
			stk.push(c);
			exist[index] = true;
		}
		StringBuilder str = new StringBuilder();
		while(!stk.isEmpty()){
			str.insert(0, stk.pop());
		}
		return str.toString();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		System.out.println(obj.removeDuplicateLetters("aabcabg"));
	}

}

import java.util.*;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s==null||s.length()==0 ||t==null||t.length()==0) return false;
		int[] alpha = new int[26];
		Arrays.fill(alpha, 0);
		for(int i = 0;i<s.length();i++){
			int index = s.charAt(i)- 'a';
			alpha[index]++;
		}
		for(int i = 0;i<t.length();i++){
			int index = t.charAt(i)- 'a';
			alpha[index]--;
		}
		for(int i=0;i<26;i++){
			if(alpha[i]>0) return false;
		}
		return true;
 	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidAnagram obj = new ValidAnagram();
		String s = "anagram";
		String t = "nagaram";
		System.out.println(obj.isAnagram(s, t));
	}

}

import java.util.*;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if(s==null || s.length()==0) return false;
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++){
			if(!set.add(s.charAt(i))){
				set.remove(s.charAt(i));
			}
		}
		return set.size()<=1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutation obj = new PalindromePermutation();
		System.out.println(obj.canPermutePalindrome("aaddssffre"));
	}

}

import java.util.*;

public class FirstUniqueCharacterInString {
	public int firstUniqChar(String s) {
		if(s==null || s.length()==0) return 0;
		int[] charcount = new int[26];
		Arrays.fill(charcount, 0);
		for(int i = 0;i<s.length();i++){
			int index = s.charAt(i)-'a';
			charcount[index]++;
		}
		for(int i=0;i<s.length();i++){
			int index = s.charAt(i)-'a';
			if(charcount[index]==1){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();
		String s = "loveleetcode";
		System.out.println(obj.firstUniqChar(s));
	}

}

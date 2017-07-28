import java.util.*;

public class RepeatedSubstrigPattern {
	public boolean repeatedSubstringPattern(String s) {
		if(s==null || s.length()<=1) return true;
		int len = s.length();
		for(int i=len/2;i>=1;i--){
			if(len%i==0){
				int numofdivisions = len/i;
				String str = s.substring(0, i);
				StringBuilder st = new StringBuilder();
				for(int j=0;j<numofdivisions;j++){
					st.append(str);
				}
				if(st.toString().equals(s)){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedSubstrigPattern obj = new RepeatedSubstrigPattern();
		System.out.println(obj.repeatedSubstringPattern("abcabcab"));
	}

}

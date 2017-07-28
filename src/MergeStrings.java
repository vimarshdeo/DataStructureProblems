import java.util.*;

public class MergeStrings {
	public static String mergestring(String[] strings){
		if(strings==null || strings.length==0) return null;
		int[] arr = new int[26];
		for(String s:strings){
			for(int i=0;i<s.length();i++){
				if(Character.isLowerCase(s.charAt(i))){
					arr[s.charAt(i)-'a']++;
				}
			}
		}
		StringBuilder str = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			while(arr[i]!=0){
				str.append((char)(i+'a'));
				arr[i]--;
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeStrings obj = new MergeStrings();
		String[] strings = {"vimarsh","12dEo"};
		System.out.println(obj.mergestring(strings));
	}

}

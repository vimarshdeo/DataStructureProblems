import java.util.*;

public class PhoneNumberCombinations {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if(digits.length()==0 || digits==null) return res;
		String[] comb = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
		res.add("");
		for(int i=0;i<digits.length();i++){
			int temp = digits.charAt(i)-'0';
			while(res.peek().length()==i){
				String s = res.removeFirst();
				for(char c:comb[temp].toCharArray()){
					res.add(s+c);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "23";
		PhoneNumberCombinations obj = new PhoneNumberCombinations();
		List<String> res = obj.letterCombinations(digits);
		for(String s:res){
			System.out.println(s);
		}
	}

}

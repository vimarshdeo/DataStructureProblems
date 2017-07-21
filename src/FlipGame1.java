import java.util.*;

public class FlipGame1 {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		if(s==null||s.length()<2) return res;
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)=='+'&& s.charAt(i+1)=='+'){
				res.add(s.substring(0, i)+"--"+s.substring(i+2));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlipGame1 obj = new FlipGame1();
		List<String> res = obj.generatePossibleNextMoves("++++");
		for(String s:res){
			System.out.println(s);
		}
	}

}

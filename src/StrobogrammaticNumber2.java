import java.util.*;

public class StrobogrammaticNumber2 {
	public List<String> findStrobogrammatic(int n) {
		return helper(n,n);
	}
	public List<String> helper(int n, int m){
		if(n==0) return new ArrayList<String>(Arrays.asList(""));
		if(n==1) return new ArrayList<String>(Arrays.asList("1","0","8"));
		
		List<String> list = helper(n-2,m);
		List<String> res = new ArrayList<>();
		for(String s:list){
			if(n!=m) res.add("0"+s+"0");
			res.add("1"+s+"1");
			res.add("8"+s+"8");
			res.add("6"+s+"9");
			res.add("6"+s+"6");
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrobogrammaticNumber2 obj = new StrobogrammaticNumber2();
		List<String> res = obj.findStrobogrammatic(3);
		for(String s:res)
			System.out.println(s);
	}

}

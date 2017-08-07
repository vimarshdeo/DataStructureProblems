import java.util.*;

public class Arpitdecimalquestion {
	public double[] find(double amount, int persons){
		if(amount==0) return new double[0];
		int div = (int)amount/persons;
		double[] res = new double[persons];
		Arrays.fill(res, div);
		double remainder = amount%persons;
		double share = Math.round((remainder/persons)*100.0)/100.0;;
		if(share*persons!=remainder) res[0]+= share+(remainder-(share*persons));
		for(int i=1;i<res.length;i++){
			
			res[i]+= share;
			
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arpitdecimalquestion obj = new Arpitdecimalquestion();
		double[] res = obj.find(10, 3);
		for(double i:res){
			System.out.println(i);
		}
	}

}

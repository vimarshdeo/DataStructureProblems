import java.util.*;

public class FractionTORecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0) return "0";
		StringBuilder res = new StringBuilder();
		if((numerator<0 && denominator>0)||(numerator>0 && denominator<0)) res.append("-");
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		res.append(num/den);
		num = num%den;
		if(num==0) return res.toString();
		res.append(".");
		HashMap<Long,Integer> map = new HashMap<>();
		map.put(num, res.length());
		while(num!=0){
			num = num*10;
			res.append(num/den);
			num = num%den;
			if(map.containsKey(num)){
				int index = map.get(num);
				res.insert(index, "(");
				res.append(")");
				break;
			}
			else{
				map.put(num, res.length());
			}
		}
		return res.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionTORecurringDecimal obj = new FractionTORecurringDecimal();
		System.out.println(obj.fractionToDecimal(1, 3));
	}

}

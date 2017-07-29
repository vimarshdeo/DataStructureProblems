import java.util.*;

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if(n==0) return 1;
		int res =10;
		int unique = 9;
		int available = 9;
		while(n>1 && available>0){
			unique *= available;
			available--;
			res += unique;
			n--;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumbersWithUniqueDigits obj = new CountNumbersWithUniqueDigits();
		System.out.println(obj.countNumbersWithUniqueDigits(2));
	}

}

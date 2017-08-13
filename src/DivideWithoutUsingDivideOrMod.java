import java.util.*;

public class DivideWithoutUsingDivideOrMod {
	public int divide(int dividend, int divisor) {
		int sign =1;
		int res=0;
		if(dividend==0) return res;
		if(divisor==0) return Integer.MAX_VALUE;
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) sign =-1;
		if(dividend<divisor) return 0;
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);
		long lans = ldivide(ldividend, ldivisor);
		if(lans>Integer.MAX_VALUE){
			return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
		}
		return sign *(int)lans;
		
	}
	public long ldivide(long dividend, long divisor){
		if(dividend<divisor) return 0;
		long sum = divisor;
		int multiple = 1;
		while((sum+sum)<=dividend){
			sum += sum;
			multiple += multiple;
		}
		return multiple + ldivide(dividend-sum,divisor);
	}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideWithoutUsingDivideOrMod obj = new DivideWithoutUsingDivideOrMod();
		System.out.println(obj.divide(Integer.MAX_VALUE	,2));
	}

}

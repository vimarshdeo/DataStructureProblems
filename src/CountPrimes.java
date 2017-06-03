import java.util.*;

public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] notprime = new boolean[n];
		int count  = 0;
		for(int i=2;i<n;i++){
			if(notprime[i]==false) count++;
			for(int j = 2;i*j<n;j++){
				notprime[i*j] = true;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes obj = new CountPrimes();
		System.out.println(obj.countPrimes(10));
	}

}

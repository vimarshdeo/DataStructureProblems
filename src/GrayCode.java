import java.util.*;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<1<<n;i++){
			res.add(i ^ i>>1);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode obj = new GrayCode();
		System.out.println(obj.grayCode(3));
	}

}

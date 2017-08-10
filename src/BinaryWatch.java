import java.util.*;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		for(int h=0;h<12;h++){
			for(int m=0;m<60;m++){
				if(Integer.bitCount(h)+Integer.bitCount(m)==num){
					res.add(String.format("%d:%02d", h,m));
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch obj = new BinaryWatch();
		List<String> res = obj.readBinaryWatch(3);
		for(String s:res){
			System.out.println(s);
		}
	}

}

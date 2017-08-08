import java.util.*;

public class UTF8Encoding {
	public boolean validUtf8(int[] data) {
		if(data==null || data.length==0) return false;
		int count=0;
		for(int d:data){
			if(count==0){
				if(d>>>5==0b110) count = 1;
				else if(d>>>4== 0b1110) count=2;
				else if(d>>>3==0b11110) count=3;
				else if(d>>>7== 0b1) return false;
			}
			else{
				if(d>>>6!=0b10) return false;
				count--;
			}
		}
		return count==0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UTF8Encoding obj = new UTF8Encoding();
		int[] data = {235, 140, 4};
		System.out.println(obj.validUtf8(data));
	}

}

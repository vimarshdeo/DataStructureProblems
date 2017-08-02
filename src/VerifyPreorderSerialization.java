import java.util.*;

public class VerifyPreorderSerialization {
	public boolean isValidSerialization(String preorder) {
		if(preorder==null || preorder.length()==0) return true;
		String[] arr = preorder.split(",");
		int degree = -1;
		for(String s:arr){
			degree++;
			if(degree>0) return false;
			if(!s.equals("#")){
				degree -= 2;
			}
		}
		return degree==0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSerialization obj = new VerifyPreorderSerialization();
		System.out.println(obj.isValidSerialization("9,3,4,#,#,#,#,#,2,#,6,#,#"));
	}

}

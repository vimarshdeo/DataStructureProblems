import java.util.*;

public class StudentAttendance1 {
	public boolean checkRecord(String s) {
		if(s==null || s.length()==0) return true;
		int absent = 0;
		int late = 0;
		int maxlate = Integer.MIN_VALUE;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='A'){
				absent++;
				late = 0;
			}
			else if(c=='L'){
				late++;
				maxlate = Math.max(maxlate, late);
			}
			else{
				late = 0;
			}
		}
		return (absent<=1 && maxlate<=2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAttendance1 obj = new StudentAttendance1();
		System.out.println(obj.checkRecord("PPALLL"));
	}

}

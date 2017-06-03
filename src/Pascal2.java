import java.util.*;

public class Pascal2 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		if(rowIndex<0) return res;
		for(int i=0;i<=rowIndex;i++){
			res.add(0, 1);
			for(int j = 1;j<res.size()-1;j++){
				res.set(j, res.get(j)+res.get(j+1));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pascal2 obj = new Pascal2();
		System.out.println(obj.getRow(3));
	}

}

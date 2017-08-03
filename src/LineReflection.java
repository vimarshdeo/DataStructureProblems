import java.util.*;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		if(points==null || points.length==0) return true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		HashSet<String> set = new HashSet<>();
		for(int[] p:points){
			max = Math.max(max, p[0]);
			min = Math.min(min, p[0]);
			String s = p[0]+"a"+p[1];
			set.add(s);
		}
		int sum = max+min;
		for(int[] p:points){
			String s = sum-p[0]+"a"+p[1];
			if(!set.contains(s)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineReflection obj = new LineReflection();
		int[][] points = {{1,1},{-1,1}};
		System.out.println(obj.isReflected(points));
	}

}

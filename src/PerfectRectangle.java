import java.util.*;

public class PerfectRectangle {
	public boolean isRectangleCover(int[][] rectangles) {
		if(rectangles.length==0||rectangles[0].length==0) return false;
		int x1,y1,x2,y2,area;
		x1 = y1 = Integer.MAX_VALUE;
		x2 = y2 = Integer.MIN_VALUE;
		area = 0;
		HashSet<String> set = new HashSet<>();
		for(int[] rec:rectangles){
			x1 = Math.min(x1, rec[0]);
			y1 = Math.min(y1, rec[1]);
			x2 = Math.max(x2, rec[2]);
			y2 = Math.max(y2, rec[3]);
			
			area += ((rec[3]-rec[1])*(rec[2]-rec[0]));
			String s1 = rec[0]+" "+rec[1];
			String s2 = rec[0]+" "+rec[3];
			String s3 = rec[2]+" "+rec[1];
			String s4 = rec[2]+" "+rec[3];
			
			if(!set.add(s1)) set.remove(s1);
			if(!set.add(s2)) set.remove(s2);
			if(!set.add(s3)) set.remove(s3);
			if(!set.add(s4)) set.remove(s4);
		}
		if(!set.contains(x1+" "+y1)||!set.contains(x1+" "+y2)||!set.contains(x2+" "+y1)||!set.contains(x2+" "+y2)||set.size()!=4){
			return false;
		}
		return area==((y2-y1)*(x2-x1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectRectangle obj = new PerfectRectangle();
		int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		System.out.println(obj.isRectangleCover(rectangles));
	}

}

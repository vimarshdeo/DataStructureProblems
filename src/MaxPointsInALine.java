import java.util.*;

public class MaxPointsInALine {
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	public int maxPoints(Point[] points) {
		if(points==null) return 0;
		if(points.length<=2) return points.length;
		HashMap<Double, Integer> map = new HashMap<>();
		int max = 0;
		for(int i=0;i<points.length;i++){
			int duplicate = 1;
			int vertical = 0;
			for(int j=i+1;j<points.length;j++){
				if(points[i].x==points[j].x){
					if(points[i].y==points[j].y){
						duplicate++;
					}
					else{
						vertical++;
					}
				}
				else{
					double slope = (points[i].y==points[j].y?0.0:
						(1.0*(points[j].y-points[i].y)/points[j].x-points[i].x));
					map.put(slope, map.getOrDefault(slope, 0)+1);
				}
			}
			for(int value:map.values()){
				if((duplicate+value)>max) max = duplicate+value;
			}
			max = Math.max(max, vertical+duplicate);
			map.clear();
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsInALine obj = new MaxPointsInALine();
		Point point1 = obj.new Point(0,0);
		Point point2 = obj.new Point(1,0);
		Point point3 = obj.new Point(1,1);
		Point point4 = obj.new Point(2,0);
		Point point5 = obj.new Point(0,5);
		Point[] points = {point1,point2,point3,point4,point5};
		System.out.println(obj.maxPoints(points));
		
	}

}

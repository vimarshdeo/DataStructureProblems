import java.util.*;

public class HistogramMaxRextangleArea {
	public int largestRectangleArea(int[] heights) {
		if(heights==null) return 0;
		int maxarea,area;
		maxarea = area = 0;
		int i;
		Stack<Integer> stk = new Stack<>();
		for(i = 0;i<heights.length;){
			if(stk.isEmpty()||heights[stk.peek()]<heights[i]){
				stk.push(i++);
			}
			else{
				int top = stk.pop();
				if(stk.isEmpty()){
					area = heights[top]*i;
				}
				else{
					area = heights[top]*(i-stk.peek()-1);
				}
				
			}
			maxarea = Math.max(area, maxarea);
		}
		while(!stk.isEmpty()){
			int top = stk.pop();
			if(stk.isEmpty()){
				area = heights[top]*i;
			}
			else{
				area = heights[top]*(i-stk.peek()-1);
			}
			maxarea = Math.max(area, maxarea);
		}
		return maxarea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HistogramMaxRextangleArea obj = new HistogramMaxRextangleArea();
		int[] heights = {2,1,5,6,2,3};
		System.out.println(obj.largestRectangleArea(heights));
	}

}

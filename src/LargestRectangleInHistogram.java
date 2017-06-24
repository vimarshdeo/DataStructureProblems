import java.util.*;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		if(heights==null || heights.length==0) return 0;
		Stack<Integer> stk = new Stack<>();
		int maxarea,area,i;
		maxarea = area = 0;
		for(i=0;i<heights.length;){
			if(stk.isEmpty()||heights[i]>heights[stk.peek()]){
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
				maxarea = Math.max(maxarea, area);
			}
		}
		while(!stk.isEmpty()){
			int top = stk.pop();
			if(stk.isEmpty()){
				area = heights[top]*i;
			}
			else{
				area = heights[top]*(i-stk.peek()-1);
			}
			maxarea = Math.max(maxarea, area);
		}
		return maxarea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] heights = {2,1,5,6,2,3};
		System.out.println(obj.largestRectangleArea(heights));
	}

}

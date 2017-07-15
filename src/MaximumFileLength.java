import java.util.*;

public class MaximumFileLength {
	public int lengthLongestPath(String input) {
		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		int max = 0;
		for(String s:input.split("\n")){
			int level = s.lastIndexOf("\t")+1;
			while((level+1)<stk.size()) stk.pop();
			int length = stk.peek()+s.length()-level+1;
			stk.push(length);
			if(s.contains(".")) max = Math.max(max, length-1);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumFileLength obj = new MaximumFileLength();
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(obj.lengthLongestPath(input));
	}

}

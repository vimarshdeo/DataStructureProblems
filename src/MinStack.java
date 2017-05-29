import java.util.*;

public class MinStack {
	Stack<Integer> stk = new Stack<>();
	Stack<Integer> minstack = new Stack<>();
	public MinStack() {
		stk = new Stack<>();
		minstack = new Stack<>();
	}
	public void push(int x) {
		if(minstack.isEmpty() || minstack.peek()>=x){
			minstack.push(x);
		}
		stk.push(x);
	}
	public void pop() {
		if(stk.peek()==minstack.peek()){
			minstack.pop();
		}
		stk.pop();
	}
	public int top() {
		return stk.peek();
	}
	public int getMin() {
		return minstack.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj  = new MinStack();
		obj.push(2);
		obj.push(1);
		obj.push(3);
		obj.push(0);
		obj.push(2);
		System.out.println(obj.getMin());
		System.out.println(obj.top());
	}
}

import java.util.*;

public class BadSwap {
	public class D{
		int a;
		int b;
		public D(int t,int i){
			a=t;
			b=i;
		}
		public void print(){
			System.out.println(a+" "+b);
		}
	}
	public void swap(D obj3){
		int temp = obj3.a;
		obj3.a=obj3.b;
		obj3.b= temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BadSwap obj= new BadSwap();
		D obj1=obj.new D(100,200);
		obj1.print();
		obj.swap(obj1);
		obj1.print();
		int a = 10;
		int b = 20;
		mySwap(a,b);
		System.out.println(a + " " + b);
	}
	
	public static void mySwap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
		
	}
}

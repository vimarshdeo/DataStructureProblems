import java.util.*;

public class ShortenUrl {
	 public String shorturl(int id) {
		 String arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		 int size = arr.length();
		 StringBuilder str = new StringBuilder();
		 while(id>0){
			 str.append(arr.charAt(id%size));
			 id = id/size;
		 }
		 while(str.length()<6) str.append("0");
		 return str.reverse().toString();
 	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortenUrl obj = new ShortenUrl();
		System.out.println(obj.shorturl(245));
	}

}

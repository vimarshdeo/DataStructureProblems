import java.util.*;

public class SentenceScreenFitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		System.out.println(s);
        int start = 0, l = s.length();
        System.out.println("length: "+l);
        for (int i = 0; i < rows; i++) {
            start += cols;
            System.out.println("start: "+start);
            if (s.charAt(start % l) == ' ') {
            	System.out.println("if: "+s.charAt(start%l));
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                	System.out.println("else: "+s.charAt((start-1)%l));
                    start--;
                }
            }
        }
        
        return start / s.length();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SentenceScreenFitting obj = new SentenceScreenFitting();
		String[] sentence = {"a", "bcd", "e"};
		System.out.println(obj.wordsTyping(sentence, 3, 6));
	}

}

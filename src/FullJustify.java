import java.util.*;

public class FullJustify {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		int index = 0;
		while(index<words.length){
			int last = index +1;
			int count  = words[index].length();
			while(last<words.length){
				if(count+words[last].length()+1>maxWidth) break;
				count += words[last].length()+1;
				last++;
			}
			StringBuilder str = new StringBuilder();
			str.append(words[index]);
			int diff = last-index-1;
			if(last==words.length || diff==0){//last line or one words in the line, left justified
				for(int i = str.length();i<maxWidth;i++){
					str.append(" ");
				}
			}
			else{
				int space = (maxWidth-count)/diff;
				int extraspace = (maxWidth-count)%diff;
				for(int a= index+1;a<last;a++){
					for(int i = space;i>=0;i--){
						str.append(" ");
					}
					if(extraspace--!=0){
						str.append(" ");
					}
					str.append(" ");
					str.append(words[a]);
				}	
			}
			list.add(str.toString());
			index = last;
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FullJustify obj = new FullJustify();
		String[] words  = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		System.out.println(obj.fullJustify(words, L));
	}

}

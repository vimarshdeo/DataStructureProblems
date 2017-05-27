import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(wordList==null || wordList.size()==0) return 0;
		int len = 0;
		HashSet<String> beginSet = new HashSet<>();
		beginSet.add(beginWord);
		HashSet<String> endSet = new HashSet<>();
		endSet.add(endWord);
		HashSet<String> visited = new HashSet<>();
		while(!beginSet.isEmpty()&& !endSet.isEmpty()){
			if(beginSet.size()>endSet.size()){
				HashSet<String> temp = beginSet;
				beginSet = endSet;
				endSet = temp;
			}
			HashSet<String> tempset = new HashSet<>();
			for(String word:beginSet){
				char[] arr = word.toCharArray();
				
				for(int i=0;i<arr.length;i++){
					for(char c = 'a';c<='z';c++){
						char old = arr[i];
						arr[i] = c;
						String target = new String(arr);
						if(endSet.contains(target)){
							return len+1;
						}
						if(!visited.contains(target) && wordList.contains(target)){
							tempset.add(target);
							visited.add(target);
						}
						arr[i]=old;
					}
				}
			}
			beginSet = tempset;
			len++;
		}
		return -1;
	}
	public static void main(String[] args) {
		HashSet<String> wordList = new HashSet<>();
		wordList.add("cat");
		wordList.add("bat");
		wordList.add("ban");
		wordList.add("bcn");
		wordList.add("rtt");
		WordLadder obj = new WordLadder();
		System.out.println(obj.ladderLength("cat","bcn",wordList));
	}

}

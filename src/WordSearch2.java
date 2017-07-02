import java.util.*;

public class WordSearch2 {
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word = null;
	}
	public TrieNode buildtree(String[] words){
		TrieNode root = new TrieNode();
		for(String s:words){
			TrieNode temp = root;
			for(char c:s.toCharArray()){
				if(temp.next[c-'a']==null){
					temp.next[c-'a'] = new TrieNode();
				}
				temp = temp.next[c-'a'];
			}
			temp.word = s;
		}
		return root;
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if(board.length==0 || board[0].length==0 || board==null) return res;
		TrieNode root = buildtree(words);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				dfs(board,i,j,res, root);
			}
		}
		return res;
	}
	public void dfs(char[][] board, int i, int j, List<String> res, TrieNode temp){
		char c = board[i][j];
		if(c=='#' || temp.next[c-'a']==null) return;
		board[i][j] = '#';
		temp = temp.next[c-'a'];
		if(temp.word!=null){
			res.add(temp.word);
			temp.word = null;
		}
		for(int[] dir:dirs){
			int newx = i+dir[0];
			int newy = j+dir[1];
			if(newx<0||newx>=board.length||newy<0||newy>=board[0].length) continue;
			dfs(board,newx,newy,res,temp);
		}
		board[i][j] = c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch2 obj = new WordSearch2();
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] wordDict = {"oath","pea","eat","rain"};
		for(String s:obj.findWords(board, wordDict)){
			System.out.println(s);
		}
	}

}

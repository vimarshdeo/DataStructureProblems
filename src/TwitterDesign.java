import java.util.*;

public class TwitterDesign {
	private static int timestamp;
	private HashMap<Integer, User> map;
	private class Tweet{
		public int tweetid;
		public int time;
		public Tweet next;
		public Tweet(int id){
			this.tweetid = id;
			time = timestamp++;
			next = null;
		}
	}
	public class User{
		public int userid;
		public HashSet<Integer> followset;
		public Tweet tweethead;
		public User(int id){
			userid = id;
			followset = new HashSet<>();
			tweethead = null;
			follow(id);
		}
		private void posttweet(int id){
			Tweet t = new Tweet(id);
			t.next = tweethead;
			tweethead = t;
		}
		public void follow(int id){
			followset.add(id);
		}
		public void unfollow(int id){
			followset.remove(id);
		}
	}
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
        	User u = new User(userId);
        	map.put(userId, u);
        }
        map.get(userId).posttweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!map.containsKey(userId)) return res;
        Set<Integer> set = map.get(userId).followset;
        if(set==null) return res;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(set.size(),(a,b)->(b.time-a.time));
        for(Integer uid:set){
        	Tweet temp = map.get(uid).tweethead;
        	if(temp!=null){
        		pq.add(temp);
        	}
        }
        int n=0;
        while(!pq.isEmpty() && n<10){
        	Tweet t = pq.poll();
        	res.add(t.tweetid);
        	n++;
        	if(t.next!=null){
        	    pq.add(t.next);
        	}
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        if(!map.containsKey(followerId)){
        	User u = new User(followerId);
        	map.put(followerId, u);
        }
        if(!map.containsKey(followeeId)){
        	User u  = new User(followeeId);
        	map.put(followeeId, u);
        }
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || followerId==followeeId) return;
        map.get(followerId).unfollow(followeeId);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

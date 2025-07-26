class Twitter {

    List<Tweet> tweetPool;
    Map<Integer, User> userMap;

    public Twitter() {    
        tweetPool = new ArrayList<>();
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        tweetPool.add(tweet);

        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        User user = userMap.get(userId);
        if(user == null){
            user = new User(userId);
            userMap.put(userId, user);
        }
        for(int i=tweetPool.size()-1; i>=0 && tweets.size()<10; i--){
            Tweet tweet = tweetPool.get(i);
            if(tweet.userId == user.id || user.followers.contains(tweet.userId)){
                tweets.add(tweet.tweetId);
            }
        }
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if(user == null) {
            user = new User(followerId);
            userMap.put(user.id, user);
        }
        if(followee == null){
            userMap.put(followeeId, new User(followeeId));
        }
        user.followers.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        user.followers.remove(followeeId);
    }
}

class User {
    int id;
    Set<Integer> followers;

    User(int id){
        this.id = id;
        this.followers = new HashSet<>();
    }
}

class Tweet {
    int tweetId;
    int userId;

    Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
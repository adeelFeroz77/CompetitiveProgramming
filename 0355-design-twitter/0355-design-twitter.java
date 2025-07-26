class Twitter {

    Map<Integer, User> userMap;
    int timestamp = 0;

    public Twitter() {    
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        if(!userMap.containsKey(userId)){
            user = new User(userId);
            userMap.put(userId, user);
        }
        user.addTweet(tweetId, timestamp++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        User user = userMap.get(userId);
        if(user == null){
            user = new User(userId);
            userMap.put(userId, user);
        }
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.timestamp - a.timestamp);
        pq.addAll(user.tweets);
        for(Integer id: user.followers){
            pq.addAll(getTweetsByUserId(id));
        }

        while(!pq.isEmpty() && tweets.size() < 10){
            tweets.add(pq.poll().tweetId);
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

    private List<Tweet> getTweetsByUserId(int userId){
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }
        return userMap.get(userId).tweets;
    }
}

class User {
    int id;
    Set<Integer> followers;
    List<Tweet> tweets;

    User(int id){
        this.id = id;
        this.followers = new HashSet<>();
        this.tweets = new ArrayList<>();
    }

    void addTweet(int tweetId, int timestamp){
        tweets.add(new Tweet(this.id, tweetId, timestamp));
    }
}

class Tweet {
    int tweetId;
    int userId;
    int timestamp;

    Tweet(int userId, int tweetId, int timestamp) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.timestamp = timestamp;
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
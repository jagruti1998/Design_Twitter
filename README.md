# Design_Twitter
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.


**APPROACH**

**1.Twitter**

- initialize hashmap posttweet it will contain user-id with ArrayList of pair of tweetid and time
- initialize hashmap followers. it will contain userid with a set of all the following userid (followeid)
- initialize time (it will increment time after each call of postTweet)



**2.Follow and unFollow**

- get HashSet of followerid from hashmap of followers
- add/remove followeeId in HashSet
- add hashset into hashmap with followerid


**3.PostTweet**
- Make new Pair consisting of tweetid and time
- get ArrayList of userid then add the pair to the arraylist
- add ArrayList in hashmap for userid
- increment time value by 1


**4.getFeedNews (Most important)**
- get list of followers of userid including userid in set
- make a HashMap for the tweets of all the followers and user by using pair which consists of tweetid and timestamp
- Make PriorityQueue (MinHeap) of the hashMap
- if the size of priorityqueue is less than 10 skip this step. while the size of priorityQueue is more than 10 remove one element from PriorityQueue till it is 10.
- add all the remaining tweetid in PriorityQueue into ArrayList
- return reverse of ArrayList

**Complexity**
- twitter
     - Time complexity - O(1)
     - space Complexity - O(1)
 
- postTweet
     - Time complexity - O(1)
     - space Complexity - O(1)
 
- gwtNewsFeed
     - Time complexity - O(followers*tweets)
     - space Complexity - O(n)

- follow
     - Time complexity - O(1)
     - space Complexity - O(n)

- unfollow
     - Time complexity - O(1)
     - space Complexity - O(n)

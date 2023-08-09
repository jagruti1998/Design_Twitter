# Design_Twitter
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.


**APPROACH**

**Twitter**

The most important factor is it uses contiguous memory allocation of data where a block of memory is reserved for a data structure.
It is an infinite collection of homogeneous(similar type) elements.

- initialize hashmap posttweet it will contain userid with arraylist of pair of tweetid and time
- initialize hashmap followers. it will contains userid with set of all the following userid (followeid)
- initialize time (it will increment time after each call of postTweet)

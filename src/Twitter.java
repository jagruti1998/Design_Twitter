import java.util.*;

class Twitter {

    HashMap<Integer,ArrayList<Pair<Integer,Integer>>> posttweet; // map<userid, < tweetId, time>>
    HashMap<Integer,Set<Integer>> followers;
    int time;

    public Twitter() {
        posttweet = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Pair<Integer,Integer> pair = new Pair<>(tweetId, time);
        ArrayList<Pair<Integer,Integer>> temp = posttweet.getOrDefault(userId, new ArrayList<>());
        temp.add(pair);
        posttweet.put(userId, temp);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = followers.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        list.addAll(set);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : list) {
            if (posttweet.get(i) != null) {
                for (Pair<Integer,Integer> j : posttweet.get(i)) {
                    map.put(j.getKey(), j.getValue());
                }
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(((x,y) -> x.getValue() - y.getValue()));
        pq.addAll(map.entrySet());
        while (pq.size() > 10) {
            pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while (pq.size() != 0) {
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followers.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<>());
        if (set.contains(followeeId)) {
            set.remove(followeeId);
        }
        followers.put(followerId, set);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Twitter twitter = new Twitter();

        while (true) {
            System.out.println("1. Post Tweet");
            System.out.println("2. Get News Feed");
            System.out.println("3. Follow User");
            System.out.println("4. Unfollow User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter tweet ID: ");
                    int tweetId = scanner.nextInt();
                    twitter.postTweet(userId, tweetId);
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextInt();
                    List<Integer> newsFeed = twitter.getNewsFeed(userId);
                    System.out.println("News Feed: " + newsFeed);
                    break;
                case 3:
                    System.out.print("Enter follower ID: ");
                    int followerId = scanner.nextInt();
                    System.out.print("Enter followee ID: ");
                    int followeeId = scanner.nextInt();
                    twitter.follow(followerId, followeeId);
                    break;
                case 4:
                    System.out.print("Enter follower ID: ");
                    followerId = scanner.nextInt();
                    System.out.print("Enter followee ID: ");
                    followeeId = scanner.nextInt();
                    twitter.unfollow(followerId, followeeId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

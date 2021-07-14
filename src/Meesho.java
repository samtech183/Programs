import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.lang.reflect.*;

class UserRepository {

    private HashMap<Integer, User> userRepo = new HashMap<>();

    public User getUserById(Integer userId) {
        User user = userRepo.get(userId);
        if(user==null) {
            //System.out.print("User Not Found with uid hence creating new user " + userId);
            user = new User(userId);
            saveUser(user);
        }
        return user;
    }

    public Boolean saveUser(User user) {
        userRepo.put(user.userId, user);
        return true;
    }
}

class User {
    Integer userId;
    List<Integer> followers;
    List<Integer> following;
    List<Post> posts;
    List<Post> userNewsFeed;


    public User(Integer uid) {
        userId = uid;
        followers = new LinkedList<>();
        following = new LinkedList<>();
        posts = new LinkedList<>();
        userNewsFeed = new LinkedList<>();
    }
}

class Post implements Comparable<Post> {
    Integer postId;
    Long timestamp;

    @Override
    public int compareTo(Post post) {
        return post.timestamp.compareTo(this.timestamp);
    }

    public Post(Integer pId) {
        postId = pId;
        timestamp = System.currentTimeMillis();
    }
}

class Facebook {

    UserRepository userRepository = new UserRepository();


    public void createPost(Integer userId, Integer postId) {
        User user = userRepository.getUserById(userId);
        Post post = new Post(postId);
        user.posts.add(post);
        user.userNewsFeed.add(post);
        Collections.sort(user.userNewsFeed);

        List<Integer> followers = user.followers;
        for(Integer followerId : followers) {
            User follower = userRepository.getUserById(followerId);
            follower.userNewsFeed.add(new Post(postId));
            Collections.sort(follower.userNewsFeed);
        }
    }

    public void deletePost(Integer userId, Integer postId) {

        User user = userRepository.getUserById(userId);
        List<Post> posts = user.posts;
        List<Post> userNewsFeed = user.userNewsFeed;

        int postIndex = findPostIndex(postId , posts);
        posts.remove(postIndex);
        int newsFeedIndex = findPostIndex(postId , userNewsFeed);
        userNewsFeed.remove(newsFeedIndex);

        List<Integer> followers = user.followers;
        for(Integer followerId : followers) {
            System.out.println("follower id   " + followerId);
            User follower = userRepository.getUserById(followerId);
            int nFIndex = findPostIndex(postId , follower.userNewsFeed);
            if(nFIndex==-1) {
                System.out.println("post not present in follower's feed " + postId);
                continue;
            }
            System.out.println("index for " + nFIndex);
            follower.userNewsFeed.remove(nFIndex);
        }

    }

    private int findPostIndex(Integer postId, List<Post> posts) {
        for(int index=0;index<posts.size();index++){
            if(posts.get(index).postId.equals(postId)) {
                return index;
            }
        }
        return -1;
    }

    public void follow(Integer userId, Integer followeeId) {
        User followee = userRepository.getUserById(followeeId);
        List<Integer> followers = followee.followers;
        if(!followers.contains(userId)) {
            followers.add(userId);
        }
        else {
            System.out.println("User " + userId + "already a follower of " + followeeId);
        }

        List<Post> foloweePosts = followee.posts;
        Integer followerId = userId;
        User follower = userRepository.getUserById(followerId);
        follower.following.add(followeeId);

        List<Post> folowerNewsFeed = follower.userNewsFeed;
        for(Post foloweePost : foloweePosts) {
            folowerNewsFeed.add(foloweePost);
        }
        Collections.sort(folowerNewsFeed);
    }

    public void unfollow(Integer userId, Integer followeeId) {
        User followee = userRepository.getUserById(followeeId);
        List<Integer> followers = followee.followers;
        if(followers.contains(userId)) {
            followers.remove(userId);
        }
        else {
            System.out.println("User " + userId + "already not a follower of " + followeeId);
        }
    }

    public void getNewsFeed(Integer userId) {
        //List<Integer> feed = new ArrayList<>();
        User user = userRepository.getUserById(userId);
        List<Post> newsFeed = user.userNewsFeed;
        int count = 10;
        int index = 0;
        int feedSize = newsFeed.size();
        count = Math.min(feedSize , count);

        System.out.print("[");
        while(count>1) {
            System.out.print(newsFeed.get(index).postId + ", ");
            index++;
            count--;
        }
        System.out.print(newsFeed.get(index).postId);
        System.out.println("]");
    }

    public void getNewsFeedPaginated(Integer userId, Integer pageNumber) {
        // Write your code here

    }
}

public class Meesho {
    public static void main(String[] args) throws IOException {
        Meesho meesho = new Meesho();
        Facebook facebook = new Facebook();
        facebook.createPost(1,5);
        facebook.getNewsFeed(1);
        facebook.follow(1,2);
        facebook.createPost(2,6);
        facebook.getNewsFeed(1);
        facebook.createPost(1,7);
        facebook.getNewsFeed(1);
        facebook.getNewsFeed(2);
        facebook.follow(2,1);
        facebook.getNewsFeed(2);
        facebook.getNewsFeed(2);
    }
}

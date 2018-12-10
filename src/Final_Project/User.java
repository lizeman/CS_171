//package Final_Project;

import java.util.*;

public class User {

    private String name;

    private String profile;

    private ArrayList<User> friendList = new ArrayList<User>();

    public User(String name, String profile, ArrayList<User> friendList) {
        this.name = name;
        this.profile = profile;
        this.friendList = friendList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }


    public void setFriendList(User user) {
        this.friendList.add(user);
    }

    public void removeFriend(String name) {
        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).getName().equals(name)){
                friendList.remove(i);
                return;
            }
        }
    }
}

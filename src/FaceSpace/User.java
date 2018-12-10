package FaceSpace;//package Final_Project;

import java.util.ArrayList;

public class User {

    private String name;

    private String profile;

    private ArrayList<User> FriendList;

    public User Upper_user;

    public User(String name, String profile, ArrayList<User> friendList) {
        this.name = name;
        this.profile = profile;
        FriendList = friendList;
        Upper_user = null;
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
        return FriendList;
    }


    public void setFriendList(User user) {
        this.FriendList.add(user);
    }

    public boolean removeFriend(String name) {
        User tmp = new User(name, "", null);
        if (FriendList.contains(tmp)) {
            FriendList.remove(tmp);
            return true;
        }

        System.out.println("not found the friendship between " + name + " and " + this.name);
        return false;

    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User tmp = (User) obj;
        return this.name.equals(tmp.getName());
    }

    @Override
    public String toString() {
        return "name: " + name.toString() + " profile: " + profile.toString();
    }
}

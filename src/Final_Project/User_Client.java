//package Final_Project;

import java.util.ArrayList;

public class User_Client {
    private ArrayList<User> UserList;

    public User_Client() {
        UserList = new ArrayList<User>();
    }

    public void addUser(String name, String profile) {
        for (User tmp : UserList) {
            if (tmp.getName().equals(name)) {
                System.out.println("The username exists, change another one");
                return;
            }
        }
        UserList.add(new User(name, profile, new ArrayList<User>()));
    }

    public User getUser(String name) {
        for (User tmp : UserList) {
            if (tmp.getName().equals(name)) {
                return tmp;
            }
        }
        return null;
    }

    public void addFriend(String name1, String name2) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getName().equals(name1)) {
                for (int j = 0; j < UserList.size(); j++) {
                    if (UserList.get(j).getName().equals(name2)) {
                        UserList.get(i).setFriendList(UserList.get(j));
                        UserList.get(j).setFriendList(UserList.get(i));
                        return;
                    }
                }
            }
        }
        System.out.println("Not found existing user");
    }

    public void deleteFriend(String name1, String name2) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getName().equals(name1)) {
                for (int j = 0; j < UserList.size(); j++) {
                    if (UserList.get(j).getName().equals(name2)) {
                        UserList.get(i).removeFriend(name2);
                        UserList.get(j).removeFriend(name1);
                        return;
                    }
                }
            }
        }
        System.out.println("Not found existing user");
    }

    public void ShowAllUser() {
        for (User tmp : UserList) {
            System.out.println(tmp.getName() + " : " + tmp.getProfile() + " : " + tmp.getFriendList());
        }
    }


    public static void main(String args[]) {
        User_Client test = new User_Client();
        test.addUser("1", "12312313");
        test.addUser("2", "12312313");
        test.addUser("3", "12312313");
        test.addUser("4", "12312313");
        test.addUser("5", "12312313");

        test.addFriend("1", "2");
        test.ShowAllUser();
        test.deleteFriend("1", "2");
        test.ShowAllUser();

    }

}

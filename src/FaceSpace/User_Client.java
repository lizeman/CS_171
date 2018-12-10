package FaceSpace;//package Final_Project;

import java.util.ArrayList;
import java.util.Scanner;


public class User_Client {

    private HashTableLinearProbe<String, User> HashUserList;

    public User_Client() {
        HashUserList = new HashTableLinearProbe<String, User>(8);
    }


    public void addUser(String name, String profile) {
        if (HashUserList.contains(name)) {
            System.out.println("The username already exist, please change to another one");
        }

        HashUserList.put(name, new User(name, profile, new ArrayList<User>()));
    }

    public User getUser(String name) {
        return HashUserList.get(name);
    }


    public void addFriend(String name1, String name2) {
        User tmp1 = HashUserList.get(name1);
        User tmp2 = HashUserList.get(name2);

        if (tmp1 != null && tmp2 != null) {
            tmp1.setFriendList(tmp2);
            tmp2.setFriendList(tmp1);
            return;
        }
        System.out.println("Not found existing user");

    }

    public void deleteFriend(String name1, String name2) {
        User tmp1 = HashUserList.get(name1);
        User tmp2 = HashUserList.get(name2);

        if (tmp1 != null && tmp2 != null) {
            if (tmp1.removeFriend(name2)) {
                tmp2.removeFriend(name1);
                return;
            }
            return;
        }
        System.out.println("Not available");

    }

    public void removeUser(String name) {
        HashUserList.delete(name);

    }

    public void ShowAllUser() {
        System.out.println(HashUserList);
    }

    public void FindShortestPath(String name1, String name2) {
        User tmp1 = HashUserList.get(name1);
        User tmp2 = HashUserList.get(name2);

        if (tmp1 == null || tmp2 == null) {
            System.out.println("Not available");
            return;
        }

        BFS bfs = new BFS(HashUserList, tmp1, tmp2);

    }


    public static void main(String args[]) {
        User_Client test = new User_Client();
        System.out.println("type help to show help commands");

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String method = scan.nextLine().toUpperCase().trim();
            if(method.equals("")){
                continue;
            }
            switch (method) {
                case "ADD":
                    String line1 = scan.nextLine();
                    String[] fields1 = line1.split(" ");
                    if (fields1.length < 2){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    String username = fields1[0].trim();
                    String profile = fields1[1].trim();
                    test.addUser(username, profile);
                    break;
                case "ADDF":
                    String line2 = scan.nextLine();
                    String[] fields2 = line2.split(" ");
                    if (fields2.length < 2){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    String username1 = fields2[0].trim();
                    String username2 = fields2[1].trim();
                    test.addFriend(username1, username2);
                    break;
                case "GETF":
                    String username3 = scan.nextLine();
                    if (username3.equals("")){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    System.out.println(test.getUser(username3).getFriendList());
                    break;
                case "DELF":
                    String line3 = scan.nextLine();
                    String[] fields3 = line3.split(" ");
                    if (fields3.length < 2){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    String username4 = fields3[0].trim();
                    String username5 = fields3[1].trim();
                    test.deleteFriend(username4, username5);
                    break;
                case "SP":
                    String line4 = scan.nextLine();
                    String[] fields4 = line4.split(" ");
                    if (fields4.length < 2){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    String username6 = fields4[0].trim();
                    String username7 = fields4[1].trim();
                    test.FindShortestPath(username6, username7);
                    break;
                case "SHOWALL":
                    test.ShowAllUser();
                    break;
                case "GET":
                    String username8 = scan.nextLine();
                    if (username8.equals("")){
                        System.out.println("Not enough parameters, check help!");
                        break;
                    }
                    System.out.println(test.getUser(username8));
                    System.out.println("FriendList: " +test.getUser(username8).getFriendList());
                    break;
                case "HELP":
                    System.out.println("Commmand Lists");
                    System.out.println("add = add new user | need username and profile, separate by space");
                    System.out.println("get = get an exisiting user | need username");
                    System.out.println("addf = add new friendrelationship | need username1 and username2, separate by space");
                    System.out.println("getf = get a user's friendlist | need username");
                    System.out.println("delf = del exisiting friendrelationship | need username1 and username2, separate by space");
                    System.out.println("SP = show the shortest path between two users | need username1 and username2, separate by space");
                    System.out.println("showall = show all users | not recommended");
                    break;

                default:
                    System.out.println("no match");
            }
        }

    }

}
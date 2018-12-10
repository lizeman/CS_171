//SUBMITTED BY: David(LI ZEMAN)

import java.util.Stack;
import java.util.ArrayList;


// A celebrity at a party is someone that is known by everyone, but knows nobody himself or herself.
// Task: Given a 2d matrix of acquaintances, find the celebrity.

public class Party {

    int[][] acquaintances;

    public Party(int[][] acquaintances) {
        // it's best if we make a defensive copy of the array we are given...
        int numPeople = acquaintances.length;
        this.acquaintances = new int[numPeople][numPeople];
        for ( int i= 0; i < numPeople; i++) {
            for (int j = 0; j < numPeople; j++) {
                this.acquaintances[i][j] = acquaintances[i][j];
            }
        }
    }

    private boolean knows(int a, int b) {
        return ((acquaintances[a][b] == 1) ? true : false);
    }

    public int findCelebrity() {
        Stack<Integer> stack = new Stack();
        for ( int i = 0; i < this.acquaintances[0].length; i++)
            stack.push(i);
        while(stack.size() != 1 ){
            int tmp1 = stack.pop();
            int tmp2 = stack.pop();
            if(knows(tmp1, tmp2))
                stack.push(tmp2);
            else {
                stack.push(tmp1);
            }
        }

        int finalOne = stack.pop();

        for ( int i = 0; i < this.acquaintances.length; i++)
        {
            if (i != finalOne && (knows(finalOne, i) ||
                    !knows(i, finalOne)))
                return -1;
        }
        return finalOne;
    }

    public static void main(String[] args) {

        // the structure of the array below is that
        // if acquaintances[a][b] == 1, then "a knows b"
        // if acquaintances[a][b] == 0, then "a does not know b"

        int[][] acquaintances = {{0,1,1,1},
                                 {1,0,1,0},
                                 {0,0,0,0},
                                 {1,0,1,0}};

        Party party = new Party(acquaintances);
        int celebrity = party.findCelebrity();

        if (celebrity == -1)
            System.out.println("No Celebrity");
        else
            System.out.println("Celebrity ID = " + celebrity);
    }
}
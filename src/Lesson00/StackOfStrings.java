import java.util.Scanner;
public class StackOfStrings {

    private String[] items;
    private int size;

    public StackOfStrings(int capacity) {
        items = new String[capacity];
        size = 0; //superfluous
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == items.length);
    }

    public void push(String s) {
        if (this.isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        items[size++] = s;
    }

    public String pop() {
        if(this.isEmpty()){
            throw new RuntimeException("Stack underflow");
        }
        return items[--size];
    }

    public static void main(String[] args){
        System.out.println("Enter a sequence of words and/or dashes separated by spaces.");
        System.out.println("Words will be pushed to an initially empty stack with capacity 5.");
        System.out.println("Dashes will result in popping the stack and printing the result.");
        Scanner scanner = new Scanner(System.in);
        String userInputStr = scanner.nextLine();
        scanner.close();
        String[] userInputs = userInputStr.split(" ");
        StackOfStrings stack = new StackOfStrings(5);
        for ( int i= 0; i < userInputs.length; i++) {
            if (userInputs[i].equals("-"))
                System.out.println(stack.pop());
            else
                stack.push(userInputs[i]);
        }
    }
}

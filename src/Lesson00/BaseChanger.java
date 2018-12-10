//SUBMITTED BY: David(LI ZEMAN)

import java.util.Scanner;
import java.util.Stack;

public class BaseChanger {

    public String convert(int n, int base) {
        Stack<Integer> stack = new Stack<>();
        int tmp;
        StringBuilder changer = new StringBuilder();
        while(n != 0 ){
            tmp = n % base;
            stack.push(tmp);
            n = (n - tmp)/base;
        }

        while (!stack.isEmpty())
            changer.append(Integer.toString(stack.pop()));

        return changer.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter a number to convert and the base to convert it to, separated by a space");

        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        scanner.close();

        int n = Integer.parseInt(inputs[0]);
        int base = Integer.parseInt(inputs[1]);

        BaseChanger baseChanger = new BaseChanger();
        System.out.println(baseChanger.convert(n,base));
    }
}

import java.util.*;
import java.util.Stack;

public class Postfix {

    public static int evaluate(String expression){
        Stack<Integer> operand = new Stack<>();

        for( int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);

            if (ch == ' ')
                continue;
            else if (Character.isDigit(ch)) {
                int n = 0;

                while (Character.isDigit(ch)) {
                    n = n * 10 + (int) (ch - '0');
                    i++;
                    ch = expression.charAt(i);
                }
                i--;

                operand.push(n);
            }
            else{
                int val1 = operand.pop();
                int val2 = operand.pop();

                switch (ch){
                    case '+': operand.push(val1+val2); break;
                    case '-': operand.push(val1-val2); break;
                    case '*': operand.push(val1*val2); break;
                    case '/': operand.push(val2/val1); break;

                }
            }
        }
        return operand.pop();

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.print(evaluate(s));

    }
}

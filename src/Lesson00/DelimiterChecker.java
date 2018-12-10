//import java.util.*;
//
//public class DelimiterChecker {
//
//    public static final int NO_ERROR = 0;
//    public static final int MATCHING_ERROR = 1;
//    public static final int MISSING_RIGHT_DELIMITER_ERROR = 2;
//    public static final int MISSING_LEFT_DELIMITER_ERROR = 3;
//
//    public boolean isValid(String inputStr) {
//
//        Stack<Integer> stack = new Stack<Integer>();
//
//        //get chars in turn...
//        for(int j=0; j<inputStr.length(); j++) {
//            char ch = inputStr.charAt(j); // get char
//            switch(ch) {
//                case '{': // opening symbols
//                case '[':
//                case '(':
//                    stack.push(ch); // push them
//                    break;
//                case '}': // closing symbols
//                case ']':
//                case ')':
//                    if ( !stack.isEmpty() ) {
//                        char chx = stack.pop(); // pop and check
//                        if ( (ch=='}' && chx!='{') ||
//                                (ch==']' && chx!='[') ||
//                                (ch==')' && chx!='(')    ) {
//                            printError(inputStr, j, MATCHING_ERROR);
//                            return false;
//                        }
//                    }
//                    else { // prematurely empty
//                        printError(inputStr, j, MISSING_LEFT_DELIMITER_ERROR);
//                        return false;
//                    }
//                    break;
//                default: // no action on other characters
//                    break;
//            } // end switch
//        } // end for
//
//        // at this point, all characters have been processed
//        if ( !stack.isEmpty() ) {
//            printError(inputStr, inputStr.length(), MISSING_RIGHT_DELIMITER_ERROR);
//            return false;
//        }
//
//        printError(inputStr, 0, NO_ERROR);
//        return true;
//
//    } // end isValid()
//
//    private void printError(String inputStr, int posOfError, int typeOfError) {
//
//        if (typeOfError != NO_ERROR) {
//            System.out.println(inputStr);
//
//            for (=0; i < posOfError; i++) {
//                System.out.print(" ");
//            }
//            System.out.println("^");  // a visual marker of where the error has occurred
//        }
//
//        switch (typeOfError) {
//            case MATCHING_ERROR                :
//                System.out.println("Paired delimeters do not match"); break;
//            case MISSING_RIGHT_DELIMITER_ERROR :
//                System.out.println("Missing right delimiter"); break;
//            case MISSING_LEFT_DELIMITER_ERROR  :
//                System.out.println("Missing left delimiter"); break;
//        }
//    }
//
//    public static void main(String[] args) {
//        DelimiterChecker dc = new DelimiterChecker();
//        System.out.println("Enter an expression to check..");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        scanner.close();
//        System.out.println();
//        System.out.println( (!dc.isValid(s) ? "An error was found" : "No errors were found"));
//    }
//
//}
// Java Program to find the
// solution of the arithmetic
// using the stack
import java.util.*;

class solution {
    public int stacky(String[] tokens)
    {

        // Initialize the stack and the variable
        Stack<String> stack = new Stack<>();
        int x, y;
        String result;
        String choice;
        int value;
        String p = "";

        // Iterating to each character
        // in the array of the string
        for (String thistoken : tokens) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            if (!thistoken.equals("+") && !thistoken.equals("-") && !thistoken.equals("*") && !thistoken.equals("/")) {
                stack.push(thistoken);
                continue;
            } else {
                // else if the character is the special
                // character then use the switch method to
                // perform the action
                choice = thistoken;
            }

            // Switch-Case
            switch (choice) {
                case "+" -> {

                    // Performing the "+" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                }
                case "-" -> {

                    // Performing the "-" operation by popping
                    // put the first two character
                    // and then again store back to the stack
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                }
                case "*" -> {

                    // Performing the "*" operation
                    // by popping put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                }
                case "/" -> {

                    // Performing the "/" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                }
                default -> {
                }
            }
        }

        // Method to convert the String to integer
        return Integer.parseInt(stack.pop());
    }

    public String convertToReversePolish(String exp) {
        if (exp == null)
            return null;
        String res = "";
        int len = exp.length();
        Stack<Character> operator = new Stack<>();
        Stack<String> reversePolish = new Stack<>();
        //avoid checking empty
        operator.push('#');
        for (int i = 0; i < len;) {
            //deal with space
            while (i < len && exp.charAt(i) == ' ')
                i++;
            if (i == len)
                break;
            //if is number
            if (isNum(exp.charAt(i))) {
                StringBuilder num = new StringBuilder();
                while (i < len && isNum(exp.charAt(i)))
                    num.append(exp.charAt(i++));
                reversePolish.push(num.toString());
                //is operator
            } else if (isOperator(exp.charAt(i))) {
                char op = exp.charAt(i);
                switch (op) {
                    case '(':
                        operator.push(op);
                        break;
                    case ')':
                        while (operator.peek() != '(')
                            reversePolish.push(Character.toString(operator.pop()));
                        operator.pop();
                        break;
                    case '+':
                    case '-':
                        if (operator.peek() == '(')
                            operator.push(op);
                        else {
                            while (operator.peek() != '#' && operator.peek() != '(')
                                reversePolish.push(Character.toString(operator.pop()));
                            operator.push(op);
                        }
                        break;
                    case '*':
                    case '/':
                        if (operator.peek() == '(')
                            operator.push(op);
                        else {
                            while (operator.peek() != '#' && operator.peek() != '+' &&
                                    operator.peek() != '-' && operator.peek() != '(')
                                reversePolish.push(Character.toString(operator.pop()));
                            operator.push(op);
                        }
                        break;
                }
                i++;
            }
        }
        while (operator.peek() != '#')
            reversePolish.push(Character.toString(operator.pop()));
        while (!reversePolish.isEmpty())
            res = res.length() == 0? reversePolish.pop() + res: reversePolish.pop() + " " + res;
        return  res;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
    }

class GFG {

    public static void main() {
        System.out.println("Example:");
        calculate("(100+200)*3-10");
        System.out.println("Enter Equation:");
        Scanner scan = new Scanner(System.in);  //defining an object to scan/get input from user, notice the use of "new", this means you are making an object of type Scanner.
        String input = scan.next();  //Using nextInt() method to get a value
        calculate(input);
    }

    public static void calculate(String input){
        solution str = new solution();
        System.out.println(input);
        String reversePolish =  str.convertToReversePolish(input);
        System.out.println(reversePolish);
        String[] reversePolish_to_array = reversePolish.split(" ");
        System.out.println(Arrays.toString(reversePolish_to_array));
        int answer = str.stacky(reversePolish_to_array);
        System.out.println(answer);
    }
}
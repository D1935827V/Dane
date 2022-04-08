// Java Program to find the
// solution of the arithmetic
// using the stack
import java.util.*;

class solution {
    public int stacky(String[] tokens)
    {

        // Initialize the stack and the variable
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";

        // Iterating to the each character
        // in the array of the string
        for (int i = 0; i < tokens.length; i++) {

            // If the character is not the special character
            // ('+', '-' ,'*' , '/')
            // then push the character to the stack
            String thistoken = tokens[i];
            if (!thistoken.equals("+") && !thistoken.equals("-") && !thistoken.equals("*") && !thistoken.equals("/")) {
                stack.push(tokens[i]);
                continue;
            }
            else {
                // else if the character is the special
                // character then use the switch method to
                // perform the action
                choice = tokens[i];
            }

            // Switch-Case
            switch (choice) {
                case "+":

                    // Performing the "+" operation by popping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "-":

                    // Performing the "-" operation by poping
                    // put the first two character
                    // and then again store back to the stack
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;

                case "*":

                    // Performing the "*" operation
                    // by poping put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "/":

                    // Performing the "/" operation by poping
                    // put the first two character
                    // and then again store back to the stack

                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;

                default:
                    continue;
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
        Stack<Character> operator = new Stack<Character>();
        Stack<String> reversePolish = new Stack<String>();
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
                String num = "";
                while (i < len && isNum(exp.charAt(i)))
                    num += exp.charAt(i++);
                reversePolish.push(num);
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

    public static void main(String args[])
    {

        solution str = new solution();
        System.out.println("100 + 200");
        String s =  str.convertToReversePolish("100 + 200");
        System.out.println(s);
        String[] x = s.split(" ");
        System.out.println(Arrays.toString(x));
        int result = str.stacky(x);
        System.out.println(result);
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;



public class calculator {

        // Helper definition for supported operators
        private final Map<String, Integer> OPERATORS = new HashMap<>();

        {
                // Map<"token", precedence>
                OPERATORS.put("sqrt", 2);
                OPERATORS.put("^", 2);
                OPERATORS.put("*", 3);
                OPERATORS.put("/", 3);
                OPERATORS.put("%", 3);
                OPERATORS.put("+", 4);
                OPERATORS.put("-", 4);
        }

        // Helper definition for supported operators
        private final Map<String, Integer> SEPARATORS = new HashMap<>();

        {
                // Map<"separator", not_used>
                SEPARATORS.put(" ", 0);
                SEPARATORS.put("(", 0);
                SEPARATORS.put(")", 0);
        }

        // Create a 1 argument constructor expecting a mathematical expression
        public calculator() {
        }

        // Test if token is an operator
        private boolean isOperator(String token) {
                // find the token in the hash map
                return OPERATORS.containsKey(token);
        }

        // Test if token is an seperator
        private boolean isSeperator(String token) {
                // find the token in the hash map
                return SEPARATORS.containsKey(token);
        }

        // Compare precedence of operators.
        private Boolean isPrecedent(String token1, String token2) {
                // token 1 is precedent if it is greater than token 2
                return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0);
        }

        // Term Tokenizer takes original expression and converts it to ArrayList of tokens
        public ArrayList<String> tokenizer(String expression) {
                // contains final list of tokens
                ArrayList<String> tokens = new ArrayList<>();

                int start = 0;  // term split starting index
                StringBuilder multiCharTerm = new StringBuilder();    // term holder
                for (int i = 0; i < expression.length(); i++) {
                        Character c = expression.charAt(i);
                        if (isOperator(c.toString()) || isSeperator(c.toString())) {
                                // 1st check for working term and add if it exists
                                if (multiCharTerm.length() > 0) {
                                        tokens.add(expression.substring(start, i));
                                }
                                // Add operator or parenthesis term to list
                                if (c != ' ') {
                                        tokens.add(c.toString());
                                }
                                // Get ready for next term
                                start = i + 1;
                                multiCharTerm = new StringBuilder();
                        } else {
                                // multi character terms: numbers, functions, perhaps non-supported elements
                                // Add next character to working term
                                multiCharTerm.append(c);
                        }

                }
                // Add last term
                if (multiCharTerm.length() > 0) {
                        tokens.add(expression.substring(start));
                }
                return tokens;
        }

        // Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
        public ArrayList<String> toReversePolish(ArrayList<String> tokens) {
                // contains final list of tokens in RPN
                ArrayList<String> reverse_polish = new ArrayList<>();

                // stack is used to reorder for appropriate grouping and precedence
                stack tokenStack = new stack();
                for (String token : tokens) {
                        switch (token) {
                                // If left bracket push token on to stack
                                case "(":
                                        tokenStack.push(token);
                                        break;
                                case ")":
                                        while (tokenStack.peek() != null && !tokenStack.peek().equals("(")) {
                                                reverse_polish.add((String) tokenStack.peek());
                                                tokenStack.pop();
                                        }
                                        tokenStack.pop();
                                        break;
                                case "+":
                                case "-":
                                case "*":
                                case "/":
                                case "%":
                                case "^":
                                case "sqrt":
                                        // While stack
                                        // not empty AND stack top element
                                        // and is an operator
                                        while (tokenStack.peek() != null && isOperator((String) tokenStack.peek())) {
                                                if (isPrecedent(token, (String) tokenStack.peek())) {
                                                        reverse_polish.add((String) tokenStack.peek());
                                                        tokenStack.pop();
                                                        continue;
                                                }
                                                break;
                                        }
                                        // Push the new operator on the stack
                                        tokenStack.push(token);
                                        break;
                                default:    // Default should be a number, there could be test here
                                        reverse_polish.add(token);
                        }
                }
                // Empty remaining tokens
                while (tokenStack.peek() != null) {
                        reverse_polish.add((String) tokenStack.peek());
                        tokenStack.pop();
                }
                return reverse_polish;
        }

        // Takes RPN and produces a final result
        public double calculate(ArrayList<String> reverse_polish) {

                Double result = 0.0;

                // stack is used to hold calculation while using RPN rules for calculation
                stack calc_stack = new stack();

                //loop through reverse polish list
                for (String token : reverse_polish) {
                        // If the token is a number push it onto the stack
                        if (!isOperator(token)) {
                                calc_stack.push(token);
                        } else {
                                //pop and peek 2 entries
                                Double op0 = Double.valueOf((String) calc_stack.peek());
                                calc_stack.pop();
                                Double op1 = Double.valueOf((String) calc_stack.peek());
                                calc_stack.pop();

                                //calculate results
                                switch (token) {
                                        case "+":
                                                result = op1 + op0;
                                                break;
                                        case "-":
                                                result = op1 - op0;
                                                break;
                                        case "*":
                                                result = op1 * op0;
                                                break;
                                        case "/":
                                                result = op1 / op0;
                                                break;
                                        case "%":
                                                result = op1 % op0;
                                                break;
                                        case "^":
                                                result = Math.pow(op1, op0);
                                                break;
                                        case "sqrt":
                                                result = Math.sqrt(op1);
                                                break;

                                        default:    //  replace this code with errors
                                                result = 0.0;
                                }

                                // Push intermediate result back onto the stack
                                calc_stack.push(String.valueOf(result));
                        }
                }
                // Pop final result and set as final result for expression
                result = Double.valueOf((String) calc_stack.peek());
                calc_stack.pop();

                return result;
        }

}
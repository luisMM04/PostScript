import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        // Ask the user to input a PostScript expression
        String expression = JOptionPane.showInputDialog("Enter the PostScript expression");

        // Tokenize the expression using space as the delimiter
        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        // Initialize the stack to store tokens (numbers and operators)
        Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            // Check if the token is an operator or a number
            if (isOperator(token)) {
                // Handle operator
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());

                double result = performOperation(token, operand1, operand2);
                stack.push(Double.toString(result));
            } else {
                // Handle number
                stack.push(token);
            }
        }

        // The final result should be at the top of the stack
        if (!stack.isEmpty()) {
            double finalResult = Double.parseDouble(stack.pop());
            System.out.println("Result: " + finalResult);
        } else {
            System.out.println("No result found.");
        }
    }

    // Check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("add") || token.equals("sub") || token.equals("mul") || token.equals("div");
    }

    // Perform the specified operation on two operands
    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "add":
                return operand1 + operand2;
            case "sub":
                return operand1 - operand2;
            case "mul":
                return operand1 * operand2;
            case "div":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

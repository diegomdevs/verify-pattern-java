import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        final String[] pattern = new String[4];
        pattern[0] = "[";
        pattern[1] = "]";
        pattern[2] = "[";
        pattern[3] = "]";
        final boolean result = verifyPattern(pattern);
        System.out.println("The pattern is: " + (result == true ? "correct" : "incorrect"));
    }

    public static boolean verifyPattern(String[] pattern) {
        Stack stack = new Stack();
        for (String symbol : pattern) {
            if (symbol == "[" || symbol == "{") {
                stack.push(symbol);
            } else {
                if ((symbol == "]" && stack.peek() == "[") || (symbol == "}" && stack.peek() == "{")) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.size() > 0 ? stack.peek() == "[" || stack.peek() == "{" ? false : true : true;
    }
}

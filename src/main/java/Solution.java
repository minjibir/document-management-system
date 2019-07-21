import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String wrapInListElementTag(String str) {
        return "<li>" + str.trim() + "</li>";
    }

    static int pushToTheStack(String next, String result, Stack<String> stack, int top) {
        if (!stack.empty()) {
            int in = Integer.parseInt(next.trim().substring(1, 2));

            if (top < in) {
                result.concat("<ul>");
                result.concat(wrapInListElementTag(next.split(" ")[1]));
                stack.push("</ul>");
            } else if (top > in) {
                result.concat("</ul>");
                result.concat(wrapInListElementTag(next.split(" ")[1]));
                stack.pop();
            } else {
                result.concat(wrapInListElementTag(next.split(" ")[1]));
            }
            return in;
        } else {
            result.concat("<ul>");
            result.concat(wrapInListElementTag(next.split(" ")[1]));
            stack.push("</ul>");
            return top;
        }
    }

    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        while (scanner.hasNextLine()) {
            input = Arrays.asList(scanner.nextLine().split("\\s"));
//            input.add(scanner.nextLine());
        }
        scanner.close();

        int prt = Integer.parseInt(input.get(0).trim().substring(1, 2));
        String rst = "";

        for (String str : input) {
            prt = pushToTheStack(str, rst, stack, prt);
        }

        while (!stack.empty()) {
            rst.concat(stack.pop());
        }

        System.out.println(rst);
    }
}

//H1 America
//H2 North America
//H3 United States
//H3 Canada
//H2 South America
//H3 Brazil
//H3 Uruguay
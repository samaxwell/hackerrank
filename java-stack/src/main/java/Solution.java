import java.io.OutputStream;
import java.util.*;

public class Solution {

    static boolean shouldPrint = Boolean.FALSE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> pairs = new HashMap<>();
        pairs.put("{", "}");
        pairs.put("[", "]");
        pairs.put("(", ")");

        while (sc.hasNext()) {
            String input = sc.next();
            printIf("Input --> " + input);
            Stack<String> stack = new Stack();

            for (int i = 0; i < input.length(); i++) {
                String next = String.valueOf(input.charAt(i));
                printIf("\tchar: " + next);

                if (stack.isEmpty()) {
                    printIf("\t:Pushing: " + next);
                    stack.push(next);
                }
                else if (pairs.containsKey(next)) {
                    printIf("\t:Pushing: " + next);
                    stack.push(next);
                } else {
                    String last = stack.peek();
                    printIf("\tComparing(last,next): " + pairs.get(last) + "," + next);
                    if (next.equals(pairs.get(last))) {
                        printIf("\t:Popping");
                        stack.pop();
                    }
                }
            }
            printIf("\tResult ==> " + stack.isEmpty() + "\t");
            System.out.println(stack.isEmpty());
        }
    }
    static void printIf(String stringToPrint) {
        if (shouldPrint) {
            System.out.println(stringToPrint);
        }
    }
}

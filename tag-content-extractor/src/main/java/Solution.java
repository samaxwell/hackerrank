import token.Token;
import token.Tokenizer;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Tokenizer tokenizer = new Tokenizer();
            List<Token> tokens = tokenizer.tokenize(line);

            Stack<Token> stack = new Stack<>();
            String content = null;

            for (Token t: tokens) {
                if (t.isStartToken()) {
                    stack.push(t);
                }
                else if (t.isContent()) {
                    content = t.getContent();
                }
                else if (t.isEndToken()) {
                    if (stack.peek().isPair(t) && content != null) {
                        System.out.println(content);
                    }
                    content= null;
                    stack.pop();
                }
            }

            testCases--;
        }
    }


}

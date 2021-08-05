package token;

import token.Token;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<Token> tokenize(String line) {

        List<Token> tokens = new ArrayList<>();
        while(hasMoreTokens(line)) {
            String content = getNextToken(line);
            tokens.add(new Token(content));
            line = removeToken(line, content);
        }

        return tokens;
    }

    public String getNextToken(String line) {
        if (!hasMoreTokens(line)) return "";

        if (line.startsWith(Token.OPEN_START_CHARACTERS)) {
            return line.substring(0, line.indexOf(Token.END_CHARACTERS)+1);
        }
        return line.substring(0, line.indexOf(Token.OPEN_START_CHARACTERS));
    }

    public boolean hasMoreTokens(String line) {
        return !"".equals(line);
    }

    public String removeToken(String line, String token) {
        return line.substring(token.length(), line.length());
    }

}

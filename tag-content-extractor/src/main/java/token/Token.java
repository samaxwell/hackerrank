package token;

import java.util.Objects;

public class Token {

    public static final String OPEN_START_CHARACTERS = "<";
    public static final String CLOSE_START_CHARACTERS = "</";
    public static final String END_CHARACTERS = ">";

    private String content;

    public Token(String content) {
        this.content = content;
    }

    public boolean isStartToken() {
        return content.startsWith(Token.OPEN_START_CHARACTERS) &&
                content.endsWith(Token.END_CHARACTERS) &&
                !content.startsWith(Token.CLOSE_START_CHARACTERS) ;
    }

    public boolean isEndToken() {
        return content.startsWith(Token.CLOSE_START_CHARACTERS) &&
                content.endsWith(Token.END_CHARACTERS);
    }

    public boolean isContent() {
        return !isStartToken() && !isEndToken();
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(content, token.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public boolean isPair(Token peek) {
        if (isStartToken() && peek.isEndToken()) {
            return this.content.substring(1, this.content.length()-1).equals(
                   peek.getContent().substring(2, peek.getContent().length()-1));
        }
        return false;
    }
}

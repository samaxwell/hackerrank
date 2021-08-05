package token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TokenTest {

    ///////////////////
    // isStart token.Token //
    ///////////////////
    @Test
    void givenStartToken_whenIsStartTokenIsCalled_trueIsReturned() {
        Token token = new Token("<h1>");
        Assertions.assertTrue(token.isStartToken());
    }
    @Test
    void givenEndToken_whenIsStartTokenIsCalled_falseIsReturned() {
        Token token = new Token("</h1>");
        Assertions.assertFalse(token.isStartToken());
    }
    @Test
    void givenContent1_whenIsStartTokenIsCalled_falseIsReturned() {
        Token token = new Token("hello world");
        Assertions.assertFalse(token.isStartToken());
    }
    @Test
    void givenContent2_whenIsStartTokenIsCalled_falseIsReturned() {
        Token token = new Token("<hello world");
        Assertions.assertFalse(token.isStartToken());
    }
    @Test
    void givenContent3_whenIsStartTokenIsCalled_falseIsReturned() {
        Token token = new Token("hello world>");
        Assertions.assertFalse(token.isStartToken());
    }

    /////////////////
    // isEnd token.Token //
    /////////////////
    @Test
    void givenEndToken_whenIsEndTokenIsCalled_trueIsReturned() {
        Token token = new Token("</h1>");
        Assertions.assertTrue(token.isEndToken());
    }
    @Test
    void givenStartToken_whenIsEndTokenIsCalled_FalseIsReturned() {
        Token token = new Token("<h1>");
        Assertions.assertFalse(token.isEndToken());
    }
    @Test
    void givenStartContent1_whenIsEndTokenIsCalled_FalseIsReturned() {
        Token token = new Token("h1");
        Assertions.assertFalse(token.isEndToken());
    }
    @Test
    void givenStartContent2_whenIsEndTokenIsCalled_FalseIsReturned() {
        Token token = new Token("<h1");
        Assertions.assertFalse(token.isEndToken());
    }
    @Test
    void givenStartContent3_whenIsEndTokenIsCalled_FalseIsReturned() {
        Token token = new Token("h1>");
        Assertions.assertFalse(token.isEndToken());
    }

    ///////////////
    // isContent //
    ///////////////
    @Test
    void givenContent_whenIsContentIsCalled_trueIsReturned() {
        Token token = new Token("hello");
        Assertions.assertTrue(token.isContent());
    }
    @Test
    void givenStartToken_whenIsContentIsCalled_FalseIsReturned() {
        Token token = new Token("<h1>");
        Assertions.assertFalse(token.isContent());
    }
    @Test
    void givenEndToken_whenIsContentIsCalled_FalseIsReturned() {
        Token token = new Token("</h1>");
        Assertions.assertFalse(token.isContent());
    }

    ////////////
    // isPair //
    ////////////
    @Test
    void givenPairOfTokens_whenIsPairIsCalled_trueIsReturned() {
        Token startToken = new Token("<h1>");
        Token endToken = new Token("</h1>");

        Assertions.assertTrue(startToken.isPair(endToken));
    }
    @Test
    void givenBackwardsPairOfTokens_whenIsPairIsCalled_falseIsReturned() {
        Token startToken = new Token("<h1>");
        Token endToken = new Token("</h1>");

        Assertions.assertFalse(endToken.isPair(startToken));
    }
    @Test
    void givenTwoRandomTokens_whenIsPairIsCalled_falseIsReturned() {
        Token startToken = new Token("<h1>");
        Token endToken = new Token("</h2>");

        Assertions.assertFalse(startToken.isPair(endToken));
    }
    @Test
    void givenTokenAndContent1_whenIsPairIsCalled_falseIsReturned() {
        Token startToken = new Token("<h1>");
        Token endToken = new Token("howdy");

        Assertions.assertFalse(startToken.isPair(endToken));
    }
    @Test
    void givenTokenAndContent2_whenIsPairIsCalled_falseIsReturned() {
        Token startToken = new Token("<h1>");
        Token endToken = new Token("howdy");

        Assertions.assertFalse(endToken.isPair(startToken));
    }
    @Test
    void givenSameTokenForBoth_whenIsPairIsCalled_falseIsReturned() {
        Token startToken = new Token("<h1>");

        Assertions.assertFalse(startToken.isPair(startToken));
    }
}
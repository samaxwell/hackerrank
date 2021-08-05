package token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    Tokenizer tokenizer;

    @BeforeEach
    public void beforeEach() {
        tokenizer = new Tokenizer();
    }

    //////////////
    // Tokenize //
    //////////////
    @Test
    void giveLine_whenTokenizeIsCalled_listOfTokensIsReturned() {
        String line = "<h1><a>contents</a></h1>";
        List<Token> expected = Arrays.asList(
                new Token("<h1>"),
                new Token("<a>"),
                new Token("contents"),
                new Token("</a>"),
                new Token("</h1>")
        );

        Assertions.assertEquals(expected, tokenizer.tokenize(line));
    }

    ////////////////
    // Next token.Token //
    ////////////////
    @Test
    void givenLineWithStartingCharacter_whenGetNextTokenIsCalled_TokenIsReturned() {
        String line = "<h1><a>contents</a></h1>";
        Assertions.assertEquals("<h1>", tokenizer.getNextToken(line));
    }
    @Test
    void givenLineStartingWithContent_whenGetNextTokenIsCalled_contentIsReturned() {
        String line = "</a></h1>";
        Assertions.assertEquals("</a>", tokenizer.getNextToken(line));
    }


    ///////////////////
    // hasMoreTokens //
    ///////////////////
    @Test
    public void givenLineWithTokens_whenHasMoreTokensIsCalled_trueIsReturned() {
        String line = "<p><h1>Hello</h1><p>";
        Assertions.assertTrue(tokenizer.hasMoreTokens(line));
    }
    @Test
    public void givenEmptyString_whenHasMoreTokensIsCalled_falseReturned() {
        String line = "";
        Assertions.assertFalse(tokenizer.hasMoreTokens(line));
    }

    /////////////////
    // RemoveToken //
    /////////////////
    @Test
    void givenLineAndToken_whenRemoveToken_lineIsReturnedMinusTokenAtTheBeginning() {
        String line = "<p><h1>Hello</h1><p>";
        String token = "<p>";
        String expected = "<h1>Hello</h1><p>";
        Assertions.assertEquals(expected, tokenizer.removeToken(line, token));
    }
    @Test
    void givenLineWithOneToken_whenRemoveToken_emptyStringIsReturned() {
        String line = "<p>";
        String token = "<p>";
        String expected = "";
        Assertions.assertEquals(expected, tokenizer.removeToken(line, token));
    }

    //////////////////
    // Print Tokens //
    //////////////////
//    @Test
//    public void givenValidLine_whenPrintTokenIsCalled_lineIsPrinted() {
//        String line = "<p><h1>Hello</h1><p>";
//        tokenizer.tokenize((line)).forEach(t -> System.out.println("  " + t));
//
//        Assertions.assertTrue(Boolean.TRUE);
//    }
}
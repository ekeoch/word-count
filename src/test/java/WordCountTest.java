import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCountTest {

    //null test for sentence breaker (Regex)
    @Test
    public void regexNullStringTest() {
        Assertions.assertTrue(WordCount.breakSentenceIntoWords(null).size() == 0);
    }

    //Empty string test for sentence breaker (Regex)
    @Test
    public void regexEmptyStringTest() {
        Assertions.assertTrue(WordCount.breakSentenceIntoWords("").size() == 0);
    }

    //hyphenated word test
    @Test
    public void hyphenatedWordTest() {
        String input = "off-campus, is a compound adjective and a single word";
        Assertions.assertTrue(WordCount.breakSentenceIntoWords(input).contains("off-campus"));
    }

    //multiple hyphen word test
    @Test
    public void multipleHyphenatedWordTest() {
        String input = "state-of-the-art is also a compound adjective and a single word";
        Assertions.assertTrue(WordCount.breakSentenceIntoWords(input).contains("state-of-the-art"));
    }

    //word boundary test
    @Test
    public void wordBoundaryTest() {
        String input = "\"POOF\" went the magic balloon.";
        List<String> output = WordCount.breakSentenceIntoWords(input);
        Assertions.assertTrue(output.contains("POOF"));
        Assertions.assertTrue(output.contains("balloon"));
    }

    //Complex number test e.g IP Address
    @Test
    public void complexWordMaxWordTest() {
        String input = "My ip address is 192.168.0.1.";
        Assertions.assertTrue(WordCount.breakSentenceIntoWords(input).contains("192.168.0.1"));
    }


    //null test for maxWords
    @Test
    public void maxWordsNullStringTest() {
        Assertions.assertTrue(WordCount.getMaxWords(null).size() == 0);
    }

    //Empty string test for MaxWords
    @Test
    public void maxWordsEmptyStringTest() {
        Assertions.assertTrue(WordCount.getMaxWords("").size() == 0);
    }

    //single max test
    @Test
    public void singleMaxWordTest() {
        String input = "70 is the same as Seventy.";
        List<String> output = WordCount.getMaxWords(input);
        Assertions.assertAll(
                () -> Assertions.assertTrue(output.size() == 1),
                () -> Assertions.assertTrue(output.get(0).equals("Seventy"))
        );
    }

    //multiple max test
    @Test
    public void multipleMaxWordTest() {
        String input = "fat-cat and Seventy are the same length.";
        List<String> output = WordCount.getMaxWords(input);
        Assertions.assertAll(
                () -> Assertions.assertTrue(output.size() == 2),
                () -> Assertions.assertTrue(output.contains("Seventy")),
                () -> Assertions.assertTrue(output.contains("fat-cat"))
        );
    }


    //multiline sentence test
    @Test
    public void multiSentenceMaxWordTest() {
        String input = "Lingering between sleep and wakefulness, " +
                "she savours that moment when light starts to pierce her eyelids, before reality dawns.\n" +
                "\n" +
                "The drapes, stirred by the breeze, create flickers of light and then shadow.\n" +
                "\n" +
                "She listens, hearing only her own gentle, rhythmic breathing.\n" +
                "\n" +
                "Disruption, when it comes is sudden, loud, cruel: MUM!!!";
        List<String> output = WordCount.getMaxWords(input);
        Assertions.assertAll(
                () -> Assertions.assertTrue(output.size() == 1),
                () -> Assertions.assertTrue(output.get(0).equals("wakefulness"))
        );
    }
    
}

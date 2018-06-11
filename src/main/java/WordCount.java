import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    private static final String WORD_REGEX = "\\w+[\\S\\w+]*\\b";

    private static class WordComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            //Descending order
            return o2.length() - o1.length();
        }
    }

    public static List<String> getMaxWords(String input) {

        //Simple empty input check
        if (input == null) return new ArrayList<>(0);
        if (input.trim().length() == 0) return new ArrayList<>(0);

        List<String> words = breakSentenceIntoWords(input);
        Collections.sort(words, new WordComparator());

        //remove bunch less than max length
        int maxLength = words.get(0).length();
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() < maxLength) {
                iterator.remove();
            }
        }

        return words;
    }

    protected static List<String> breakSentenceIntoWords(String input) {

        if (input == null) return new ArrayList<>(0);
        if (input.trim().length() == 0) return new ArrayList<>(0);

        //match and collect all words
        final Pattern pattern = Pattern.compile(WORD_REGEX);
        final Matcher matcher = pattern.matcher(input);

        List<String> words = new ArrayList<String>();
        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }

    public static void printMaxWords(String sentence) {
        for (String word : getMaxWords(sentence)) {
            System.out.println(word.length() + " " + word);
        }
    }

    public static void main(String[] args) {
        final String string = ".The fat cat used on the mat.";
        printMaxWords(string);
    }
}

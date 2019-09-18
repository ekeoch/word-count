package org.ekeocha;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {

    private static final String WORD_REGEX = "\\w+[\\S\\w+]*\\b";

    public static List<String> getMaxWords(String input) {

        //Simple empty input check
        if (StringUtils.isBlank(input)) return Collections.EMPTY_LIST;

        Set<String> words = breakSentenceIntoWords(input);

        int max = words.stream().mapToInt(String::length).max().getAsInt();

        return words.stream().filter(word -> word.length() == max).collect(Collectors.toList());
    }

    public static List<String> getMinWords(String input) {

        //Simple empty input check
        if (StringUtils.isBlank(input)) return Collections.EMPTY_LIST;

        Set<String> words = breakSentenceIntoWords(input);

        int min = words.stream().mapToInt(String::length).min().getAsInt();

        return words.stream().filter(word -> word.length() == min).collect(Collectors.toList());
    }

    protected static Set<String> breakSentenceIntoWords(String input) {

        //Simple empty input check
        if (StringUtils.isBlank(input)) return Collections.EMPTY_SET;

        //match and collect all words
        final Matcher matcher = Pattern.compile(WORD_REGEX).matcher(input);

        Set<String> words = new HashSet<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }

    public static void main(String[] args) {
        //get first arg from input else use default test string
        final String string = ".The fat cat played with its toy on the mat.";

        //Dump max and min
        System.out.println(String.format("Input: %s\n", string));
        System.out.println("Max Words:\n");
        getMaxWords(string).forEach(word -> System.out.println(String.format("W: [%s], L:[%d]", word, word.length())));
        System.out.println("\nMin Words:\n");
        getMinWords(string).forEach(word -> System.out.println(String.format("W: [%s], L:[%d]", word, word.length())));
    }
}

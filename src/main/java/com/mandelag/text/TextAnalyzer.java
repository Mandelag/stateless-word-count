package com.mandelag.text;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextAnalyzer {

  /**
   * Count frequency of words in input text.
   *
   * @param text The input text. Currently implemented only for latin text.
   * @return Map with the word as a key and the occurrences/frequencies as the value.
   */
  public static Map<String, Integer> countWords(String text) {
    Stream<String> stream = Arrays.stream(text.split("[^a-zA-Z]"));
    Map<String, Integer> result = stream
        .filter(token -> !"".equals(token))
        .map(String::toLowerCase)
        .collect(Collectors.toMap(str -> str, str -> 1, (prev, current) -> prev + 1));
    return result;
  }

}

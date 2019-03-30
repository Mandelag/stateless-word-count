package com.mandelag.text;

import java.util.Map;

public interface TextAnalyzer {
  /**
   * Count frequency of words in input text.
   *
   * @param text The input text. Currently implemented only for latin text.
   * @return Map with the word as a key and the occurrences/frequencies as the value.
   */
  Map<String, Integer> countWords(String text);
}

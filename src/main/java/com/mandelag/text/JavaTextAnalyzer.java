package com.mandelag.text;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaTextAnalyzer implements TextAnalyzer {

  @Override
  public Map<String, Integer> countWords(String text) {
    Stream<String> stream = Arrays.stream(text.split("[^a-zA-Z]"));
    Map<String, Integer> result = stream
        .filter(token -> !"".equals(token))
        .map(String::toLowerCase)
        .collect(Collectors.toMap(str -> str, str -> 1, (prev, current) -> prev + 1));
    return result;
  }

}

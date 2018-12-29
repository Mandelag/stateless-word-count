package com.mandelag.text;

import com.mandelag.text.TextAnalyzer;
import org.junit.Test;

import java.util.Map;

public class TextAnalyzerTest {

  @Test
  public void wordCountTest() {
    String text = "Nama saya Keenan Mandela Gebze. Sekarang " +
        "saya sedang belajar Akka. Toolkit keren dan unique!" +
        "Saya belajar ini karena saya ingin belajar distributed computing.";
    Map<String, Integer> result = TextAnalyzer.countWords(text);
    System.out.println(result);
    // dummy test
  }
}

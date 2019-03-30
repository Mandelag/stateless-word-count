package com.mandelag.text;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerTest {

  @Test
  public void wordCountTest() {
    String text = "Nama saya Keenan Mandela Gebze. Sekarang " +
        "saya sedang belajar Akka. Toolkit keren dan unique!" +
        "Saya belajar ini karena saya ingin belajar distributed computing.";
    Map<String, Integer> result = JavaTextAnalyzer.countWords(text);
    System.out.println(result);
    assertEquals(2, 1 + 1);
  }
}

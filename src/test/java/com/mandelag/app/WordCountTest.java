package com.mandelag.app;

import org.junit.Test;

import java.util.Map;

public class WordCountTest {

  @Test
  public void testWordCounter() {
    String text = "Nama saya Keenan Mandela Gebze. Sekarang " +
        "saya sedang belajar Akka. Toolkit keren dan unique!" +
        "Saya belajar ini karena saya ingin belajar distributed computing.";
    Map<String, Integer> result = WordCountProcessor.apply(text);
    System.out.println(result);
  }
}

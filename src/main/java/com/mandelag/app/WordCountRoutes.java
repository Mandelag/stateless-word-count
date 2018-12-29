package com.mandelag.app;


import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.model.StatusCodes;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Directives;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.unmarshalling.Unmarshaller;
import com.mandelag.text.TextAnalyzer;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class WordCountRoutes extends AllDirectives {

  private TextAnalyzer processor = new TextAnalyzer();

  public Route getRoute() {
    return Directives.anyOf(Directives::get, Directives::post, () -> concat(
        pathSingleSlash(() -> complete("ehehe")),
        path("ping", () -> complete("pong!")),
        path("count", this::wordCount)
    ));
  }

  public Route wordCount() {
    Unmarshaller<HttpEntity, String> unmarshaller = Unmarshaller.entityToString();
    return entity(unmarshaller, entity ->
        Directives.onSuccess(CompletableFuture.supplyAsync(() -> processor.countWords(entity)),
            extracted -> complete(StatusCodes.MULTI_STATUS, extracted, Jackson.<Map>marshaller())));
  }
}

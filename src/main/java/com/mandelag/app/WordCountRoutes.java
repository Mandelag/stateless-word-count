package com.mandelag.app;


import akka.actor.ActorRef;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Directives;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.unmarshalling.Unmarshaller;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class WordCountRoutes extends AllDirectives {

  private WordCountProcessor processor = new WordCountProcessor();

  public Route getRoute() {
    return Directives.anyOf(Directives::get, Directives::post, () -> concat(
        pathSingleSlash(() -> complete("ehehe")),
        path("ping", () -> complete("pong!")),
        path("count", this::wordCount)
        ));
  }

  public Route wordCount() {
    Unmarshaller<HttpEntity, String> umarshaller = Unmarshaller.entityToString();
    return entity(umarshaller, entity ->
        Directives.onSuccess(CompletableFuture.supplyAsync(() -> processor.apply(entity)),
        extracted -> complete(extracted.toString())));
  }
}

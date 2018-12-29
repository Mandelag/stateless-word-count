package com.mandelag.app;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.actor.Terminated;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class App {
  public static void main(String[] args) throws IOException {
    ActorSystem backendSystem = ActorSystem.create("word-counter");
    ActorSystem httpSystem = ActorSystem.create("http-server");

    Materializer materializer = ActorMaterializer.create(httpSystem);

    Flow<HttpRequest, HttpResponse, NotUsed> handler = new WordCountRoutes().getRoute().flow(backendSystem, ActorMaterializer.create(backendSystem));

    Http http = Http.get(httpSystem);
    CompletionStage<ServerBinding> bindingFuture = http.bindAndHandle(handler, ConnectHttp.toHost("0.0.0.0", 8090), materializer);

    System.in.read();

    bindingFuture
        .thenCompose(ServerBinding::unbind)
        .thenAccept(unbound -> {
          backendSystem.terminate();
          httpSystem.terminate();
        });
  }
}

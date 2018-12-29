package com.mandelag.app;


import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Directives;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.unmarshalling.Unmarshaller;

public class WordCountRoutes extends AllDirectives {

  public Route getRoute() {
    return Directives.anyOf(Directives::get, Directives::post, () -> concat(
        pathSingleSlash(() -> complete("ehehe")),
        path("ping", () -> complete("pong!")),
        path("count", () -> parameterMap(
            maps -> {
              Unmarshaller<HttpEntity, String> ums = Unmarshaller.entityToString();
              Route routeWithEntity = entity(ums, entity -> complete("hehehe "+entity+" : "+maps.toString()));
              return routeWithEntity;
            })
        ))
      );
  }
}

ThisBuild / organization := "com.mandelag.akka"
ThisBuild / version := "0.0.1"
Compile/mainClass := Some("com.mandelag.app.Main")

lazy val akkaVersion = "2.5.19"
lazy val root = (project in file("."))
  .settings(
    name := "Stateless Word Count",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-core" % "10.1.6",
      "com.typesafe.akka" %% "akka-http" % "10.1.6",
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "junit" % "junit" % "4.12")
  )


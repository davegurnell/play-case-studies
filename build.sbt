lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatest"          %% "scalatest"          % "3.0.5" % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test,
    )
  )

lazy val hello =
  project
    .in(file("0-hello"))
    .enablePlugins(PlayScala)
    .settings(commonSettings)

lazy val routes =
  project
    .in(file("1-routes"))
    .enablePlugins(PlayScala)
    .settings(commonSettings)

// This one isn't a while Play application.
// It just uses the Play JSON library.
lazy val json =
  project
    .in(file("2-json"))
    .settings(commonSettings)
    .settings(libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9")

lazy val webservices =
  project
    .in(file("3-webservices"))
    .enablePlugins(PlayScala)
    .settings(commonSettings)
    .settings(libraryDependencies += ws)

lazy val root =
  project
    .in(file("."))
    .aggregate(
      hello,
      routes,
      json,
      webservices,
    )

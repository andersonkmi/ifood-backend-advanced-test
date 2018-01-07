val ScalatraVersion = "2.6.2"

organization := "org.sharpsw"

name := "ifood-backend-advanced-test"

val appVersion = "1.0.0"

version := appVersion

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
  "org.scalatra" %% "scalatra-swagger"  % ScalatraVersion,
  "org.scalatra" %% "scalatra-commands" % ScalatraVersion,
  "org.scalatra" %% "scalatra-auth" % ScalatraVersion,
  //"org.scalatra" %% "scalatra-scalate"  % ScalatraVersion,
  //"com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.1",
  "org.json4s"   %% "json4s-native" % "3.5.2",
  "org.json4s"   %% "json4s-jackson" % "3.5.2",
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container;compile",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)

assemblyJarName in assembly := "ifood-backend-advanced-test-" + appVersion + ".jar"
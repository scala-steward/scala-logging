import sbt._

object Version {
  val logback   = "1.2.3"
  val mockito   = "3.2.6.0"
  val scalaTest = "3.2.6"
  val slf4j     = "1.7.30"
}

object Library {
  val logbackClassic                     = "ch.qos.logback"    %  "logback-classic" % Version.logback
  val mockitoScala                       = "org.scalatestplus" %% "mockito-3-4"     % Version.mockito
  def scalaReflect(scalaVersion: String) = "org.scala-lang"    %  "scala-reflect"   % scalaVersion
  val scalaTest                          = "org.scalatest"     %% "scalatest"       % Version.scalaTest
  val slf4jApi                           = "org.slf4j"         %  "slf4j-api"       % Version.slf4j
}

object Dependencies {
  import Library._

  def scalaLogging(scalaVersion: String, isDotty: Boolean) = {
    List(scalaReflect(scalaVersion)).filter(_ => !isDotty) ++
      List(
        slf4jApi,
        logbackClassic % "test",
        mockitoScala   % "test",
        scalaTest      % "test"
      )
  }
}

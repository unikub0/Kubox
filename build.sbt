ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % "test"

val osDev = System.getProperty("os.name") match {
  case a if a.contains("Windows") => "windows"
  case b if b.contains("Linux") => "linux"
}
val lwjglVer = "3.3.3"
libraryDependencies ++= Seq(
  "lwjgl",
  "lwjgl-glfw",
  "lwjgl-opengl"
).flatMap(
  module =>
    Seq(
      "org.lwjgl" % module % lwjglVer,
      "org.lwjgl" % module % lwjglVer classifier s"natives-$osDev"
    )
)
lazy val root = (project in file("."))
  .settings(
    name := "Kubox",
    idePackagePrefix := Some("id.unikub.kubox")
  )

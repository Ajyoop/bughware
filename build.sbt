val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "bughware",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    //libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
    //libraryDependencies += "com.acme.common" % "commonclass" % "1.0" from "jnativehook.jar"
    libraryDependencies += "com.1stleg" % "jnativehook" % "2.0.2"
    

    
  )

import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Hermes"
    val appVersion      = "1.0.0-SNAPSHOT"

    val appDependencies = Seq(
        "com.google.code.morphia" % "morphia" % "0.99"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        resolvers += "Morphia repository" at "http://morphia.googlecode.com/svn/mavenrepo/"
    )

}

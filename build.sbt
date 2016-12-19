import sbtassembly.Plugin.{AssemblyKeys, PathList, MergeStrategy}
import AssemblyKeys._
assemblySettings

name := "parser"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "it.unimi.dsi" % "fastutil" % "7.0.13"

scalaSource in Compile := baseDirectory.value / "src"

excludeFilter in unmanagedSources := "Berkeley.scala"

libraryDependencies ++= Seq(
  // "edu.berkeley.nlp" % "berkeleyparser" % "r32",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4" classifier "models",
  "edu.stanford.nlp" % "stanford-parser" % "3.4"
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) {
  (old) => {
    case PathList("org", "apache", "slf4j", xs@_*) => MergeStrategy.first
    case PathList("scala", "reflect", xs@_*) => MergeStrategy.first
    case PathList("com", "github.mpeltonen", "eed3si9n", "org", "scalastyle", xs@_*) => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith "axiom.xml" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
    case x => old(x)
  }
}
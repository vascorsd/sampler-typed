name := "sampler-typed"

version := "1.0"

scalaVersion := "2.11.8"

sourcesInBase := false

scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "test"

resourceDirectory in Compile := baseDirectory.value / "src" / "resources"
resourceDirectory in Test := baseDirectory.value / "test" / "resources"

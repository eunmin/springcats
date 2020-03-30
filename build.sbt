name := "springcats"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.2.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-data-mongodb" % "2.2.2.RELEASE",
  "io.springfox" % "springfox-swagger2" % "2.9.2",
  "io.springfox" % "springfox-swagger-ui" % "2.9.2",
)

libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.0"
libraryDependencies += "org.typelevel" %% "cats-free" % "2.1.0"

mainClass in Compile := Some("com.eunmin.spring.cats.Application")

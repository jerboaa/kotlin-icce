#!/usr/bin/env bash
mvn clean package
java -jar ./target/mixed-code-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar
native-image --link-at-build-time --initialize-at-build-time=. -jar target/mixed-code-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar

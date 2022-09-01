#!/usr/bin/env bash
GRAAL="$1"
if [ "${GRAAL}_" == "_" ]; then
  echo "usage: $0 <PATH_TO_GRAALVM_HOME>"
  exit 1
fi
mvn clean package
java -cp ./target/mixed-code-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar hello.JavaHello || true
$GRAAL/bin/native-image --link-at-build-time --initialize-at-build-time=. -cp ./target/mixed-code-hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar hello.JavaHello kr

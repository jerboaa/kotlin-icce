# Reproducer for IncompatibleClassChangeError

## Prerequisites
* Maven

## Steps

  ```bash
  ./run.sh
  ```

### Actual

```
[...]
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.228 s
[INFO] Finished at: 2022-08-22T14:28:52+02:00
[INFO] ------------------------------------------------------------------------
Hello from Kotlin!
Exception in thread "main" java.lang.IncompatibleClassChangeError: hello.Test and hello.Test$special$$inlined$vetoable$1 disagree on InnerClasses attribute
	at java.base/java.lang.Class.getDeclaringClass0(Native Method)
	at java.base/java.lang.Class.getDeclaringClass(Class.java:1566)
	at hello.TestKt.getHelloStringFromJava(Test.kt:17)
	at hello.JavaHello.main(JavaHello.java:12)
```

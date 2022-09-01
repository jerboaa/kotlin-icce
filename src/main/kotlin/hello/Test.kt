package hello

class Test {
  val bla = listOf("bla").sortedByDescending { it }
}

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    val x = Test()
    println(x.bla::class)
    return JavaHello.JavaHelloString
}


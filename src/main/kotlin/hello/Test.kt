package hello

import kotlin.properties.Delegates

class Test {

val bla = listOf("bla").sortedByDescending { it }
var baz: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

}

val KotlinHelloString : String = "Hello from Kotlin!"

val g = Class.forName("hello.Test\$special\$\$inlined\$vetoable\$1").declaringClass
val f = Class.forName("hello.Test\$special\$\$inlined\$sortedByDescending\$1").declaringClass

fun getHelloStringFromJava() : String {
    println(g)
    println(f)
    val x = Test()
    println(x.bla)
    return JavaHello.JavaHelloString
}


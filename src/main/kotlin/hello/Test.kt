package hello

import kotlin.properties.Delegates

class Test {

val bla = listOf("bla").sortedByDescending { it }
var baz: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    if (newValue > oldValue) true else throw IllegalArgumentException("New value must be larger than old value.")
}

fun newVal(x: Int) {
    baz = x
}

}

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    val x = Test()
    println(x.bla::class)
    x.newVal(20)
    println(x.baz)
    x.newVal(10)
    return JavaHello.JavaHelloString
}


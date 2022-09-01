package hello

import kotlin.properties.Delegates

class Test {

var baz: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    if (newValue > oldValue) true else throw IllegalArgumentException("New value must be larger than old value.")
}

fun setBazVal(x: Int) {
    baz = x
}

}

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    val x = Test()
    x.setBazVal(20)
    println(x.baz)
    return JavaHello.JavaHelloString
}


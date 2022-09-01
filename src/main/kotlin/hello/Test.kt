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
    // val g = Class.forName("hello.Test\$special\$\$inlined\$vetoable\$1").declaringClass
    val g = Class.forName("hello.Test\$special\$\$inlined\$vetoable\$1")
    val obj = g::class
    println(Test::class)
    println(obj.constructors)
    //val f = Class.forName("hello.Test\$special\$\$inlined\$sortedByDescending\$1").declaringClass
    println(g.getName())
    println(g.declaringClass)
    //println(f)
    val x = Test()
    println(x.bla::class)
    x.newVal(20)
    println(x.baz)
    x.newVal(10)
    println(x.baz)
    return JavaHello.JavaHelloString
}


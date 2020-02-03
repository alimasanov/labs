/**Напишите программу, которая будет искать все целые X, удовлетворяющие уравнению
 * A*X3 + B*X2 + C*X + D = 0, где A, B, C, D – заданные целые коэффициенты. */
//Задача из темы Простая математика №0257 Сложность 56%

fun main() {
    val a = 1
    val b = 0
    val c = 0
    val d = -27

    var i = 1

    while (i <= kotlin.math.abs(d) / 2){
        if (d % i == 0) {
            if (f(a, b, c, d, i) == 0) {
                println("root = $i")
            }
            if (f(a, b, c, d, -i) == 0) {
                println("root = ${-i}")
            }
        }
        i++
    }
}

fun f(a: Int, b: Int, c: Int, d: Int, x: Int): Int {
    return a * x * x * x + b * x * x + c * x + d
}

/**Требуется найти все совершенные числа от M до N*/
//Задача из темы Целочисленная арифметика №0364 Сложность 51%

fun main(){
    function(5, 10000)
}

fun function(m: Int, n: Int) {
    for (i in m..n) {
        var counter = 0
        var j = 1
        while (j < i) {
            if (i % j == 0) {
                counter += j
            }
            j++
        }
        if (counter == i) {
            println(counter)
        }
    }
}


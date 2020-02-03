/**Требуется найти сумму от 1 до N*/
//Задача из темы Длинная арифметика №0859 Сложность 50%

fun main() {
    sum(2)
}

fun sum(n_: Int){
    var sum = 0
    for (i in 1..n_) {
        sum += i
    }
    print(sum)
}
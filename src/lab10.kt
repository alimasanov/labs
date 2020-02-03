/**Числа Фибоначчи F1, F2, ... определяются начальными значениями и соотношением: F1=1; F2=2; Fn=Fn-1+Fn-2.
 * Рассмотрим  систему  счисления  с  двумя  цифрами  0  и  1,  в  которой,  в  отличие  от двоичной  системы,
 * весами  являются  не  степени  двойки 1,  2,  4,  8,  16,  ...,  а  числа Фибоначчи 1, 2, 3, 5, 8, 13, ....
 * В этой системе счисления каждое положительное целое число единственном способом представляется
 * в виде строки из нулей и единиц, которая начинается с 1,и в которой нет двух единиц, стоящих рядом.
 * F0=1 не учитывается.Требуется  написать  программу,  которая  выполняет  перевод  из  системы
 * счисления  Фибоначчи в двоичную систему счисления*/
//Задача из темы Системы счисления №0452 Сложность 51%

fun main() {
    val number1 = "10101"
    val number2 = "100"
    val sum = dualToFib(number1) + dualToFib(number2)
    val binSum = toBinary(sum)
    for(i in 0 until binSum.size) {
        print(binSum[i])
    }
}

fun dualToFib(number: String): Int {
    val numLength = number.length
    var counter = 0
    var sum = 0
    val list = fib(numLength - 1)
    for (i in list.size-1 downTo 0) {
        if (counter <= numLength){
            sum += Integer.parseInt("${number[counter]}") * list[i]
            counter++
        }
    }
    return sum
}

fun toBinary(num: Int): ArrayList<Int> {
    var n = num
    val sumBinary = ArrayList<Int>()
    var b: Int
    while (n != 0) {
        b = n % 2
        sumBinary.add(b)
        n /= 2
    }

    return sumBinary
}

fun fib(n: Int): ArrayList<Int> {
    val list = ArrayList<Int>()
    var i1 = 1
    var i2 = 1
    var i3: Int
    list.add(i1)

    for (i in 1..n) {
        i3 = i1 + i2
        list.add(i3)
        i1 = i2
        i2 = i3
    }
    return list
}
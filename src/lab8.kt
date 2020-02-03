/** Магический квадрат - это квадратная таблица N x N, заполненная N2 числами от 1 до N2 таким образом,
 * что сумма чисел в каждой строке, каждом столбце и на обеих диагоналях одинакова.
 * При этом числа в таблице не должны повторяться и каждое из чисел от 1 до N2 должно в ней присутствовать.

Требуется написать программу, которая по заданному N строит магический квадрат. */
//Задача из темы Двумерные массивы №0802 Сложность 70%

@file:Suppress("NAME_SHADOWING")
fun main() {
    val n = 6
    val square: Array<Array<Int>> = Array(n) {Array(n) {0} }
    printSquare(createSquare(square, n), n)
}

fun createSquare(square: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    return when {
        n % 2 == 1 -> {
            numSetOdd(square, n)
        }
        n % 4 == 0 -> {
            numSetDoubly(square, n)
        }
        else -> {
            numSetSingly(square, n)
        }
    }
}

fun numSetOdd(square: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    val nsqr = n * n
    var i = 0
    var j = n / 2

    for (k in 1..nsqr) {
        square[i][j] = k
        i--
        j++

        when {
            k % n == 0 -> {
                i += 2
                --j
            }
            j == n -> {
                j -= n
            }
            i < 0 -> {
                i += n
            }
        }
    }

    return square
}

fun numSetDoubly(square: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    val iArr: Array<Array<Int>> = Array(n) {Array(n) {0} }
    val jArr: Array<Array<Int>> = Array(n) {Array(n) {0} }

    var index = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            iArr[i][j] = ((i + 1) % 4) / 2
            jArr[j][i] = ((i + 1) % 4) / 2
            square[i][j] = index
            index++
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (iArr[i][j] == jArr[i][j]) {
                square[i][j] = n * n + 1 - square[i][j]
            }
        }
    }

    return square
}

fun numSetSingly(square: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    val p = n / 2
    val mArr: Array<Array<Int>> = Array(p) { Array(p) {0} }
    createSquare(mArr, p)

    val i: Int

    for (i in 0 until p) {
        for (j in 0 until p) {
            square[i][j] = mArr[i][j]
            square[i + p][j] = mArr[i][j] + 3 * p * p
            square[i][j + p] = mArr[i][j] + 2 * p * p
            square[i + p][j + p] = mArr[i][j] + p * p
        }
    }
    val iArr: Array<Int> = Array(p) {0}
    val jArr = ArrayList<Int>()

    for (i in 0 until p) {
        iArr[i] = i + 1
    }
    val k = (n - 2) / 4

    for (i in 1..k) {
        jArr.add(i)
    }
    for (i in n - k + 2..n) {
        jArr.add(i)
    }
    var temp: Int
    for (i in 1..p) {
        for (j in 1..jArr.size) {
            temp = square[i - 1][jArr[j - 1] - 1]
            square[i - 1][jArr[j - 1] - 1] = square[i + p - 1][jArr[j - 1] - 1]
            square[i + p - 1][jArr[j - 1] - 1] = temp
        }
    }
    i = k
    var j = 0
    temp = square[i][j]
    square[i][j] = square[i + p][j]
    square[i + p][j] = temp

    j = i
    temp = square[i + p][j]
    square[i + p][j] = square[i][j]
    square[i][j] = temp

    return square
}

fun printSquare(square: Array<Array<Int>>, n: Int) {
    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${square[i][j]}  ")
        }
        println()
    }
}
/**Требуется расставить N ферзей на клеточной шахматной доске размером N×N так,
 * чтобы ни один из них не находился под боем другого. */
//Задача из темы Математическое моделирование №0849 Сложность 54%

fun main() {
    checks(4)
}

fun checks(n: Int) {
    var table: Array<Array<String>> = Array(n) {Array(n) {"-"} }
    var counter = 0

    table = figureSet(n, 0, 1, table)
    println()
    counter++

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (table[i][j] == "-") {
                counter++
                table = figureSet(n, i, j, table)
                println()
            }
        }
    }

    println("Символом 'о' обозначается ферзь, \nСимволом 'х' обозначается ячейка, на которую нельзя поставить ферзя\n")

    if (counter == n) {
       println("Задача выполнена")
    } else {
        println("Задача не выполнена, количество установленных фигур: $counter из $n")
    }
}

fun figureSet(n: Int/*размерность*/,
              x: Int/*Индекс строки*/,
              y: Int/*Индекс столбца*/,
              impTable: Array<Array<String>>/*Таблица*/): Array<Array<String>> {

    //заполняем по горизонтали
    impTable[x] = Array(n) {"x"}

    //заполняем по вертикали
    for(i in 0 until n) {
        impTable[i][y] = "x"
    }

    var x_ = x
    var y_ = y
    //диагональ в левый верхний угол
    for (i in x downTo 0) {
        if (y_ in 0 until n) {
            impTable[i][y_] = "x"
            y_--
        } else break
    }
    //диагональ в правый верхний угол
    x_ = x
    y_ = y
    for (i in x downTo 0) {
        if (y_ in 0 until n) {
            impTable[i][y_] = "x"
            y_++
        } else break
    }
    //диагональ в правый нижний угол
    x_ = x
    y_ = y
    for (i in x until n) {
        if (y_ in 0 until n) {
            impTable[i][y_] = "x"
            y_++
        } else break
    }
    //диагональ в левый нижний угол
    x_ = x
    y_ = y
    for (i in x until n) {
        if (y_ in 0 until n) {
            impTable[i][y_] = "x"
            y_--
        } else break
    }

    //Выставляем ферзя
    impTable[x][y] = "o"

    for (col in 0 until n) {
        for (rows in 0 until n){
            print("${impTable[col][rows]}  ")
        }
        println()
    }

    return impTable
}
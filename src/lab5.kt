/**Строка S была записана много раз подряд, после чего из получившейся строки взяли подстроку и дали Вам.
 * Ваша задача определить минимально возможную длину исходной строки S. */
//Задача из темы Разбор строк №0204 Сложность 53%

fun main() {
    println(getSubString("abcabcabc"))
}

fun getSubString(string: String): String {
    val stringLength = string.length
    var substringStart = ""
    var substringEnd: String
    var substringStartLength: Int
    for(i in 1..stringLength) {
        substringStart = string.substring(0, i)
        substringStartLength = substringStart.length
        substringEnd = string.substring(substringStartLength, substringStartLength + i)
        if (substringEnd == substringStart) {
            break
        }
    }
    return substringStart
}
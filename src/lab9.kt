/**Задан шаблон, состоящий из круглых скобок и знаков вопроса.
 * Требуется определить, сколькими способами можно заменить знаки вопроса круглыми скобками так,
 * чтобы получилось правильное скобочное выражение. */
//Задача из темы Динамическое программирование №0123 Сложность 54%

import java.util.*

lateinit var s: String
lateinit var dp: Array<IntArray>
fun main() {
    val con = Scanner(System.`in`)
    s = con.next()
    val len = s.length
    dp = Array(len) { IntArray(len) }
    for (i in 0 until len) {
        Arrays.fill(dp[i], -1)
    }
    println(f(0, 0))
    con.close()
}

private fun f(n: Int, k: Int): Int {
    if (k < 0) return 0
    if (n == s.length) return if (k == 0) 1 else 0
    if (dp[n][k] != -1) return dp[n][k]
    if (s[n] == '(') return f(n + 1, k + 1).also { dp[n][k] = it }
    return if (s[n] == ')') f(n + 1, k - 1).also { dp[n][k] = it } else (f(n + 1, k - 1) + f(
        n + 1,
        k + 1
    )) % 301907.also { dp[n][k] = it }
}
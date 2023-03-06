import kotlinx.coroutines.*
import kotlin.system.exitProcess

suspend fun main(): Unit = runBlocking {
    val product = createProduct()
    val n: Int
    try {
        print("Введите количество функций: ")
        n = readLine()?.toInt() ?: 0
        if (n < 1) throw Exception()
    } catch (e: Exception) {
        println("Ошибка ввода")
        exitProcess(0)
    }

    product.doSomethingLater(2000)
    product.printStock()
    product.printDetails()

    println("Скидка: ${product.calculateDiscount()}")
    product.printSaleStatus()

    launch {
        repeat(n) {
            product.reducePrice()
        }
    }
}
fun createProduct(): MyProduct {
    try {
        print("Введите название: ")
        val name = readLine().toString()

        print("Введите цену: ")
        val price = readLine()!!.toDouble()
        if (price < 0) throw Exception()

        print("Введите еденицу измерения: ")
        val unit = readLine().toString()

        print("Введите вид товара: ")
        val type = readLine().toString()

        print("Введите количество: ")
        val quantity = readLine()!!.toInt()
        if (quantity < 1) throw Exception()

        if (name.isBlank() || unit.isBlank() || type.isBlank()) throw Exception()

        return MyProduct(name, price, unit, type, quantity)
    }
    catch (e: Exception) {
        println("Ошибка ввода данных")
        exitProcess(0)
    }
}

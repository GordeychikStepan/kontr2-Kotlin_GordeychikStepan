import kotlinx.coroutines.delay

abstract class AbstractProduct(
    override val name: String,
    override var price: Double,
    override val unit: String,
    override val type: String,
    override var quantity: Int) : Product {

    override fun printDetails() {
        println("$name: $quantity $unit по $price, ($type)")
    }
    // Функция, которая запускается в основной программе с задержкой
    suspend fun doSomethingLater(delayMillis: Long) {
        delay(delayMillis)
        println("Закончена обработка товара: $name")
    }
    // Функция, которая выводит сообщение о наличии товара на складе
    fun printStock() {
        println("$name: $quantity $unit на складе")
    }
    // Функция, которая будет со временем снижать цену товара на 10%
    suspend fun reducePrice() {
        delay(1000L)
        price *= 0.9
        println("$name: Цена снижена до $price")
    }

    abstract suspend fun calculateDiscount(): Double
    abstract suspend fun printSaleStatus()

}
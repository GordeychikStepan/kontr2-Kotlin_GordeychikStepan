import kotlinx.coroutines.delay

class MyProduct(name: String, price: Double, unit: String, type: String, quantity: Int)
    : AbstractProduct(name, price, unit, type, quantity) {

    // Вычисление скидки на товар
    override suspend fun calculateDiscount(): Double {
        delay(1000L)
        return if (quantity >= 10) {
            price * 0.1
        } else {
            0.0
        }
    }
    // Проверка, находится ли товар в распродаже
    private fun isOnSale(): Boolean {
        return quantity > 0 && price < 5.0
    }
    // Функция, которая выводит сообщение о том, находится ли товар в распродаже
    override suspend fun printSaleStatus() {
        delay(2000L)
        if (isOnSale()) {
            println("$name на распродаже.")
        } else {
            println("$name не на распродаже.")
        }
    }
}
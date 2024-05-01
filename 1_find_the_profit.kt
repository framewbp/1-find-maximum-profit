import kotlin.math.pow
fun main() {

    val prices: IntArray = intArrayOf(7, 1, 5, 3, 6, 4)
    //val prices: IntArray = intArrayOf(7, 6, 4, 3, 1)
    //val prices: IntArray = intArrayOf(7, 6, 2, 10, 1, 8, 4)
    //val prices: IntArray = intArrayOf(7, 6, 2, -1, 1000000) //Invalid input
    //val prices: IntArray = intArrayOf(1) //Invalid input
    
    println("Input: prices = " + prices.contentToString())
    if ( prices.size >= 2 && prices.size <= 10.0.pow(5)){
        val bValidPrice = checkValidPrice(prices)
        if(bValidPrice){
            val result = maximumProfit(prices)
            println("Output: $result")
        }
    } else {
        println("Invalid Input!!")
    }
}

fun maximumProfit(prices: IntArray): Int {

    var maxProfit = 0
    var minPrice = prices[0]

    for (day in 1 until prices.size) {
        val currentPrice = prices[day]
        val getProfit = currentPrice - minPrice
        maxProfit = maxOf(maxProfit, getProfit)
        minPrice = minOf(minPrice, currentPrice)
    }
    return maxProfit
}

fun checkValidPrice(prices: IntArray): Boolean {
    
    var bValuePassed = true
    for (num in prices){
        if (num < 0 || num >= 10.0.pow(4)){
            bValuePassed = false
            println("Invalid Price!!")
        }
    }
    return bValuePassed
}
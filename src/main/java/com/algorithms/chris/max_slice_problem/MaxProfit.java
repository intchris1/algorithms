package com.algorithms.chris.max_slice_problem;

/**
 * Дан лог цен на акции, найти максимально возможную прибыль.
 *
 * Для каждого i (цена продажи) максимальная выгода возможна в паре с минимальной ценой слева от i (цена покупки).
 * Нужно запоминать минимальную цену, для каждого i считать выгоду, запоминать максимальную выгоду.
 *
 * Given a log of stock prices compute the maximum possible earning.
 *
 * Each i as sell price is the most profitable paired with the minimum price to the left of i (as buy price0.
 * It is necessary to remember the minimum price, for each i calculate profit, remember the max profit.
 */
public class MaxProfit {

    public static int solution(int[] A) {
        if (A.length < 2) return 0;
        int minPrice = A[0];
        int maxProfit = 0;
        for (int price : A) {
            int profit = price - minPrice;
            if (profit > maxProfit) maxProfit = profit;
            if (price < minPrice) minPrice = price;
        }
        return maxProfit;
    }
}


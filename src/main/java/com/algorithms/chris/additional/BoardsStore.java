package com.algorithms.chris.additional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

public class BoardsStore {

    private final Queue<Batch> boardsFifo = new LinkedList<>();

    public void store(int amount, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("illegal price " + price);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("illegal amount " + amount);
        }
        boardsFifo.add(new Batch(amount, price));

    }

    public double pull(int targetAmount) {
        int toReceive = targetAmount;
        double totalPrice = 0d;
        while (toReceive > 0) {
            final var receivedBatch = boardsFifo.peek();
            if (receivedBatch == null) {
                System.out.println("There are no boards left in the queue");
            } else {
                if (batchAmountIsMoreThanNeeded(toReceive, receivedBatch.amount)) {
                    final double priceOfRetrievedBoards = receivedBatch.retrievePartOfBatch(toReceive);
                    toReceive = 0;
                    totalPrice += priceOfRetrievedBoards;
                } else {
                    toReceive -= receivedBatch.amount;
                    totalPrice += receivedBatch.getTotalPrice();
                    boardsFifo.poll();
                }
            }
        }
        return totalPrice;
    }

    public Batch checkFirstBatch() {
        Batch first = null;
        for (Batch batch : boardsFifo) {
            first = batch;
        }
        return first;
    }

    private static boolean batchAmountIsMoreThanNeeded(long toReceive, long currentBatchAmount) {
        return toReceive - currentBatchAmount < 0;
    }

    @AllArgsConstructor
    @Getter
    static class Batch {
        private int amount;
        private final double singleItemPrice;

        public double retrievePartOfBatch(int targetAmount) {
            this.amount -= targetAmount;
            return targetAmount * this.singleItemPrice;
        }

        public double getTotalPrice() {
            return this.amount * this.singleItemPrice;
        }
    }
}

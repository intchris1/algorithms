package com.algorithms.chris.codility.leader;

/**
 * Нужно вернуть индекс (любой) элемента, который повторяется больше N/2 раз.
 * Алгоритм Бойера-Мура
 * На вечеринке собрались N людей, и на каждом по одному элементу из массива.
 * Когда встречаются двое, у которых элементы разные, они присаживаются это обсудить.
 * В конце концов останутся стоять только люди с одинаковыми элементами; это может быть элемент, который встречался больше N/2 раз.
 * <p>
 * Return index (any) of an element if it occurs more than N/2 times.
 * Boyer-Moore algorithm
 * Suppose that you were to have a roomful of people each holding one element of the array.
 * Whenever two people find each other where neither is holding the same array element as the other,
 * the two of them sit down. Eventually, at the very end, if anyone is left standing, there's a chance that they're in the majority,
 * and you can just check that element. As long as one element occurs with frequency at least N/2, you can guarantee that this approach will always find the majority element.
 */
public class Dominator {

    public static int solution(int[] A) {
        Integer candidate = null;
        int confidence = 0;
        for (int i : A) {
            if (confidence == 0) {
                candidate = i;
                confidence++;
            } else if (candidate == i) {
                confidence++;
            } else {
                confidence--;
            }
        }
        if (confidence > 0) {
            confidence = 0;
            for (int i = 0; i < A.length; i++) {
                if (candidate == A[i]) {
                    confidence++;
                    if (confidence > A.length / 2) {
                        return i;
                    }
                }
            }

        }
        return -1;
    }
}

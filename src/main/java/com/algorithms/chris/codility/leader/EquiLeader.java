package com.algorithms.chris.codility.leader;

/**
 * EquiLeader - индекс S такой, что лидеры на интервале A[0], A[1], ..., A[S] и A[S + 1], A[S + 2], ..., A[N - 1] одинаковые.
 * Нужно вернуть количество эквилидеров.
 * <p>
 * 1) Найти лидера всего массива. #{@link Dominator#solution(int[]) }
 * Если такого нет, тогда нет ни одного эквилидера (лидер - больше половины элементов, если есть хотя бы один эквилидер - значит есть лидер, и наоборот).
 * 2) Составить массив счетчиков для этого элемента - чтобы можно было за O(N) посчитать, сколько таких элементов на любом интервале.
 * Пройтись по массиву, для каждого индекса смотреть, является ли элемент лидером слева от i и справа.
 * <p>
 * EquiLeader - index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 * Return the number of equileaders.
 * <p>
 * 1) Find the leader of the entire array. #{@link Dominator#solution(int[]) }
 * If there is none, then there is no equal leader (the leader is more than half of the elements, if there is at least one equal leader, then there is a leader, and vice versa).
 * 2) Make an array of counters for this element - so that you can calculate in O (N) how many such elements are in any interval.
 * Traverse the array, for each index, see if the element is the leader to the left of i and to the right.
 */
public class EquiLeader {

    public static int solution(int[] A) {
        Integer candidate = null;
        int confidence = 0;
        int result = 0;
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
            int[] counters = new int[A.length + 1];
            for (int i = 0; i < A.length; i++) {
                if (candidate == A[i]) {
                    confidence++;
                }
                counters[i + 1] = confidence;
            }
            if (confidence * 2 > A.length) {
                for (int i = 1; i < counters.length - 1; i++) {
                    boolean isLeaderOnLeft = counters[i] * 2 > i;
                    if (isLeaderOnLeft) {
                        boolean isLeaderOnRight = (counters[A.length] - counters[i]) * 2 > A.length - i;
                        if (isLeaderOnRight) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}

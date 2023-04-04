package com.algorithms.chris.neetcode.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * По однополосной дороге в один и тот же пункт назначения едут n автомобилей. Пункт назначения находится в нескольких милях от цели.
 * Вам заданы два массива целых чисел position и speed, обе длины n, где position[i] — это положение i-го автомобиля,
 * а speed[i] — скорость i-го автомобиля (в милях в час).
 * Автомобиль никогда не сможет обогнать впереди идущую машину, но может догнать ее и проехать бампер к бамперу с той же скоростью.
 * Более быстрая машина будет замедляться, чтобы соответствовать скорости более медленной машины.
 * Расстояние между этими двумя автомобилями игнорируется (т. е. предполагается, что они находятся в одном и том же положении).
 * Автопарк — это некоторое непустое множество автомобилей, движущихся в одном и том же месте и с одинаковой скоростью. Обратите внимание, что один автомобиль также является автопарком.
 * Если автомобиль догоняет автопарк прямо в пункте назначения, он все равно будет считаться одним автопарком.
 * Возвращает количество автопарков, которые прибудут в пункт назначения.
 * Решение:
 * 1) Сделать массив пар - дистанция в начале + скорость.
 * 2) Отсортировать их в обратном порядке, сравнивая дистанцию. Первыми будут те, которые находятся ближе всего к финишу.
 * 3) Для каждой такой пары высчитывать время, за которое она дойдет до финиша.
 * 4) Класть в стек.
 * 5) Сравнивать это с предыдущем значением, находящимся в стеке. Если новое значение меньше, значит, точно было пересечение с машиной, которая ближе к финишу.
 * Значит образовался автопарк, нужно удалить ту машину, которая двигается быстрее, потому что теперь она должна двигаться с более медленной скоростью.
 * <p>
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * Return the number of car fleets that will arrive at the destination.
 * Solution:
 * 1) Make an array of pairs: distance in the beginning + speed.
 * 2) Sort it in reverse order, comparing distances. The first ones are those who are closer to destination.
 * 3) For each pair calculate time, that is needed for it to reach destination.
 * 4) Put it in a stack.
 * 5) Compare it to the previous value in a stack. If a new value is less than the other, it means that there was an intersection with the car that is closer to destination.
 * It means a car fleet, delete the value which is smaller, because a quicker car now slows down to catch up to a slower car.
 */
public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, Comparator.comparingInt((int[] it) -> it[0]).reversed());
        LinkedList<Double> stack = new LinkedList<>();
        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];
            stack.addLast(time);
            if (stack.size() >= 2 && stack.peekLast() <= stack.get(stack.size() - 2)) {
                stack.removeLast();
            }
        }
        return stack.size();
    }
}

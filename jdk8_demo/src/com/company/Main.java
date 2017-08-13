package com.company;

import com.company.api.ApplePredicate;
import com.company.impl.AppleGreenColorPredicate;
import com.company.vo.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple a = new Apple();
        a.setColor("red");
        inventory.add(a);
        //List<Apple> redAndHeavyApples =
                //filterApples(inventory, new AppleGreenColorPredicate());

        List<Apple> result =
                filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        Callable<Integer> c = () -> 42;
        System.out.println(result);

    }


    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println("sss");
        return result;
    }
}

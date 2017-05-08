package com.company.impl;

import com.company.api.ApplePredicate;
import com.company.vo.Apple;

/**
 * Created by lenovo on 2017/5/8.
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

package com.craw_data.utils;

import java.util.Random;

public class MyRandom {
    private static final Random random = new Random();

    public static int randomUserNumber() {
        //TODO: refactor this hard code
        return random.nextInt(10) + 1;
    }

    public static int randomTopicNumber() {
        //TODO: refactor this hard code
        return random.nextInt(37) + 1;
    }
}

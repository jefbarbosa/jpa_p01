package com.jef.demo.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MessageUtils {

    public static String generateRandomString(int length) {
        byte[] arr = new byte[length];
        new Random().nextBytes(arr);
        return new String(arr, StandardCharsets.UTF_8);
    }
}

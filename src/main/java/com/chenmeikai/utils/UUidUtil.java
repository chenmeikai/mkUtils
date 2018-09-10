package com.chenmeikai.utils;

import java.util.UUID;

public class UUidUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replaceAll("-", "");
        return uuidStr;
    }

    public static void main(String[] arg) {
        System.out.println(getUUID());
    }
}

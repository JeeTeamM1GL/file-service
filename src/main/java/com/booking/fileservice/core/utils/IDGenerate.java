package com.booking.fileservice.core.utils;
import java.util.UUID;

public class IDGenerate {
    public static String generate(String entityName){
        return UUID.randomUUID().toString().replaceAll("-", "")
                .toUpperCase().concat(entityName.toUpperCase());
    }
}
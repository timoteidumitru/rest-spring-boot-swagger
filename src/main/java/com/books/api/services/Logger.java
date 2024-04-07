package com.books.api.services;

import java.time.LocalDateTime;

public class Logger {
    public static void LogInfo(String info){

        System.out.printf("Info at: " + LocalDateTime.now() + " --> " + info);
    }

    public static void LogError(String error){
        System.out.printf("Error at: " + LocalDateTime.now() + " --> " + error);
    }
}

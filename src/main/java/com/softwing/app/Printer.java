package com.softwing.app;

public class Printer {

    public static void println(String text){
        Printer.print(text+"\n");
    }
    
    public static void print(String text){
        System.out.print(text);
    }
}

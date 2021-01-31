package com.trycloud.utilities;

public class BrowserUtils {
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
            e.getStackTrace();
            System.out.println("Threa.sleep method was used");
        }
    }
}

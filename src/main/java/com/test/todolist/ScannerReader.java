package com.test.todolist;

import java.util.Scanner;

public class ScannerReader {
    private final Scanner scanner = new Scanner(System.in);
    protected int getNextInt(){
        String temp = scanner.nextLine();
        while (true) {
            if (scanner.hasNextInt()) {
                return Integer.parseInt(temp);
            } else {
                System.out.println("无效输入!");
            }
        }
    }

    protected String getNextString(){
        return scanner.nextLine();
    }


    protected void close(){
        scanner.close();
    }

}

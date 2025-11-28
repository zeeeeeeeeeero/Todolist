package com.test.todolist;

import java.util.Scanner;

public class ScannerReader {
    private final Scanner scanner = new Scanner(System.in);
    protected int getNextInt(){
        String temp = scanner.nextLine();
        while (true) {
            if (scanner.hasNextInt()) {
                scanner.close();
                return Integer.parseInt(temp);
            } else {
                System.out.println("无效输入!");
                scanner.nextLine();
            }
        }
    }



    protected String getNextString(){
        String temp = scanner.nextLine();
        scanner.close();
        return temp;
    }

}

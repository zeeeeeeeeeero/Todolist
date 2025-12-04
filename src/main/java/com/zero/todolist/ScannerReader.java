package com.zero.todolist;

import java.util.Scanner;

/**
 * 输入读取器类
 * 封装了Scanner，提供安全的输入读取方法
 */
public class ScannerReader {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 读取整数输入
     * 持续等待直到用户输入有效整数
     * @return 用户输入的整数
     */
    protected int getNextInt(){
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("无效输入! 请输入一个整数:");
            }
        }
    }

    protected int getNextInt(int min, int max){
        while (true){
            try{
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if(value >= min && value <= max){
                    return value;
                }
                System.out.printf("请输入%d-%d之间的数字: ", min, max);

            }catch (NumberFormatException e){
                System.out.println("无效输入! 请输入一个整数:");
            }
        }
    }

    /**
     * 读取字符串输入
     * @return 用户输入的字符串
     */
    protected String getNextString(){
        return scanner.nextLine();
    }

    /**
     * 安全关闭Scanner
     * 关闭后将无法再读取输入
     */
    protected void close(){
        scanner.close();
        System.out.println("输入流已关闭");
    }
}
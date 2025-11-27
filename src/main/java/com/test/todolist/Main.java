package com.test.todolist;

import java.util.Stack;

public class Main {
    private static Stack<Runnable> menu = new Stack<>();
    private static ScannerReader scannerReader = new ScannerReader();
    private static void mainMenu(){
        System.out.println("欢迎使用ToDoList!");
        System.out.println("输入需要操作的目录(没有将自动创建目录):");
        int temp = scannerReader.getNextInt();
        System.out.println(temp);
    }

    public static void main(String[] args) {
        menu.push(Main::mainMenu);
        while (!menu.isEmpty()){
            menu.peek().run();
        }
    }
}

package com.test.todolist;

import java.util.Stack;

public class Main {
    private static Stack<Runnable> menu = new Stack<>();
    private static ScannerReader scannerReader = new ScannerReader();
    private static void mainMenu(){
        System.out.println("欢迎使用ToDoList!");
        System.out.println("输入需要操作的目录(没有将自动创建):\n输入0将在默认目录创建.");
        String temp = scannerReader.getNextString();
        if(temp.equals("0")){
            System.out.println("已在" + "创建待办列表文件");
        }
    }


    public static void clearStack(){
        for (int i = 0; i <= menu.size(); i++){
            menu.pop();
        }
    }



    public static void main(String[] args) {
        menu.push(Main::mainMenu);
        while (!menu.isEmpty()){
            menu.peek().run();
        }
    }
}

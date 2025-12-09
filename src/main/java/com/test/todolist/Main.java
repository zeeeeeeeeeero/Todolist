package com.test.todolist;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private static Stack<Runnable> menu = new Stack<>();
    private static ScannerReader scannerReader = new ScannerReader();
    private static ArrayList<Todolist> obj_list = new ArrayList<>();
    private static void mainMenu(){
        System.out.println("欢迎使用ToDoList!");
        System.out.println("输入需要操作的目录(没有将自动创建):\n输入0将在默认目录创建.");
        int tempint = scannerReader.getNextInt();
        if(tempint == 0){
            String tempstring = scannerReader.getNextString();
            Todolist todolist = new Todolist(tempstring);
            System.out.println("已在" + "创建待办列表文件");
        }
    }


    public static void clearStack(){
        while (!menu.isEmpty()){
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

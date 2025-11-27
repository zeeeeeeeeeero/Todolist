package com.test.todolist;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private Stack<Runnable> menu = new Stack<>();

    private static void mainMenu(){
        System.out.println("欢迎使用ToDoList!\n输入功能代码:\n1.创建待办列表 2.");
    }
}

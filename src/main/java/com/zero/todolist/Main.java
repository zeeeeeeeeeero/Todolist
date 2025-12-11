package com.zero.todolist;

    /**
     * 主程序入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("欢迎使用 ToDoList 系统!");
        System.out.println("版本: 0.2");
        System.out.println("作者: zeeeeeeeeeero");

        menu.push(Menu::mainMenu);
        while (!menu.isEmpty()) {
            menu.peek().run();
        }

        System.out.println("感谢使用 ToDoList!");
        scannerReader.close();
    }
}
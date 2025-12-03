package com.test.todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Todolist {
    private static ArrayList<Todolistitem> list = new ArrayList<>();
    private String title = "";
    private static LocalDateTime datatime = LocalDateTime.now();
    private static ScannerReader scannerReader = new ScannerReader();

    public Todolist(String title){
        if(!title.isEmpty()){
            this.title = title;
        }else {
            this.title = String.valueOf(datatime);
        }

    }
    public static void addItem(){
        String temp = scannerReader.getNextString();
        Todolistitem todolistitem = new Todolistitem(temp);
        list.add(todolistitem);
    }
}
package com.test.todolist;

import java.time.LocalDateTime;

public class Specialtodolistitem extends Todolistitem{
    private String dataTime = "";
    private final LocalDateTime datetime = LocalDateTime.now();
    public Specialtodolistitem (){
        String datetime = String.valueOf(this.datetime);
        this.dataTime = datetime;
    }
}

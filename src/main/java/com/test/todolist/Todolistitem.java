package com.test.todolist;

public class Todolistitem {
    private String context = "";
    private boolean state = false;
    public Todolistitem(){}
    public Todolistitem(String context){
        this.context = context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void shift(){
        this.state = !state;
    }
}

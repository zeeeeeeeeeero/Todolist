package com.test.todolist;

/**
 * 待办事项项类
 * 表示一个待办事项的基本单元
 */
public class Todolistitem {
    private String context = "";  // 内容
    private boolean state = false; // 完成状态
    private int id; // 唯一标识符

    /**
     * 默认构造函数
     */
    public Todolistitem(){}

    /**
     * 带内容的构造函数
     * @param context 待办事项内容
     */
    public Todolistitem(String context){
        this.context = context;
    }

    /**
     * 带内容和状态的构造函数
     * @param context 待办事项内容
     * @param state 初始状态
     */
    public Todolistitem(String context, boolean state){
        this.context = context;
        this.state = state;
    }

    /**
     * 设置待办事项内容
     * @param context 待办事项内容
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 获取待办事项内容
     * @return 待办事项内容
     */
    public String getContext(){
        return context;
    }

    /**
     * 获取待办事项状态
     * @return 完成状态
     */
    public boolean getState() {
        return state;
    }

    /**
     * 设置待办事项状态
     * @param state 完成状态
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * 获取待办事项ID
     * @return 事项ID
     */
    public int getId() {
        return id;
    }

    /**
     * 设置待办事项ID
     * @param id 事项ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 切换待办事项状态
     */
    public void shift(){
        this.state = !state;
    }

    /**
     * 输出待办事项信息
     * @return 格式化的待办事项信息
     */
    @Override
    public String toString() {
        String status = state ? "[Y]" : "[N]";
        return status + " " + context;
    }
}
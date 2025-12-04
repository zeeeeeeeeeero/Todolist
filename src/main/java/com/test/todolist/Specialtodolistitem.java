package com.test.todolist;

import java.time.LocalDateTime;

/**
 * 特殊待办事项类
 * 可以设置完成时段
 */
public class Specialtodolistitem extends Todolistitem {
    private LocalDateTime creationTime;

    /**
     * 默认构造函数
     * 记录创建时间
     */
    public Specialtodolistitem() {
        super();
        this.creationTime = LocalDateTime.now();
    }

    /**
     * @param context 待办事项内容
     */
    public Specialtodolistitem(String context) {
        super(context);
        this.creationTime = LocalDateTime.now();
    }

    /**
     * @param context 待办事项内容
     * @param state 初始状态
     */
    public Specialtodolistitem(String context, boolean state) {
        super(context, state);
        this.creationTime = LocalDateTime.now();
    }

    /**
     * 获取创建时间
     * @return 创建时间
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * 设置创建时间
     * @param creationTime 创建时间
     */
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @return 格式化的特殊待办事项信息
     */
    @Override
    public String toString() {
        String baseInfo = super.toString();
        String timeStr = creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return baseInfo + " (创建于: " + timeStr + ")";
    }
}
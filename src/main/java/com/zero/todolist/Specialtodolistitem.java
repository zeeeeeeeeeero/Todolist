package com.zero.todolist;

import java.time.LocalDateTime;

/**
 * 特殊待办事项类
 * 可以设置完成时段
 */
public class Specialtodolistitem extends Todolistitem {
    private LocalDateTime creationTime;
    private LocalDateTime deadline;

    /**
     * 默认构造函数
     * 记录创建时间
     */
    public Specialtodolistitem() {
        super();
        this.creationTime = LocalDateTime.now();
        this.deadline = creationTime.plusDays(1);
    }

    /**
     * @param content 待办事项内容
     * @param deadline 截止日期
     */
    public Specialtodolistitem(String content, int deadline) {
        super(content);
        this.creationTime = LocalDateTime.now();
        this.deadline = creationTime.plusDays(deadline);
    }

    /**
     * @param content 待办事项内容
     * @param deadline 截止日期
     * @param state 初始状态
     */
    public Specialtodolistitem(String content, int deadline, boolean state) {
        super(content, state);
        this.creationTime = LocalDateTime.now();
        this.deadline = creationTime.plusDays(deadline);
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
     * @return 获取截止日期
     */
    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * @return 获取字符型截止日期
     */
    public String getStrdeadline() {
        return deadline.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * @return 是否超过截止日期
     */
    public boolean checkTimeout(){
        return !LocalDateTime.now().isBefore(deadline);
    }

    /**
     * @param deadline 设置截止日期
     */
    public void setDeadline(LocalDateTime deadline){
        if (deadline.isBefore(creationTime)){
            throw new RuntimeException("截止时间不能早于创建时间!");
        }
        this.deadline = deadline;
    }


    /**
     * @return 格式化的特殊待办事项信息
     */
    @Override
    public String toString() {
        String baseInfo = super.toString();
        String timeStr = creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String timeDeadline = deadline.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return baseInfo + " (创建于: " + timeStr +",截止于" + timeDeadline + ")";
    }
}
package com.test.todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 待办列表类
 * 待办事项的集合
 */
public class Todolist {
    private ArrayList<Todolistitem> items = new ArrayList<>();  // 当前待办事项集合
    private String title = "";  // 标题
    private LocalDateTime creationTime = LocalDateTime.now();  // 创建时间
    private int id;  // 唯一标识符
    private static int nextId = 1;  // 下一个可用的ID

    /**
     * 使用当前时间作为标题
     */
    public Todolist() {
        this.title = "待办列表_" + creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        this.id = nextId++;
    }

    /**
     * @param title 列表标题
     */
    public Todolist(String title) {
        if(!title.isEmpty()) {
            this.title = title;
        } else {
            this.title = "待办列表_" + creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        }
        this.id = nextId++;
    }

    /**
     * @return 列表标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 新的列表标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return 列表ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return 列表创建时间
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * @param context 添加待办事项内容
     */
    public void addItem(String context) {
        Todolistitem item = new Todolistitem(context);
        item.setId(items.size() + 1);  // 简单分配ID
        items.add(item);
        System.out.println("已添加待办事项: " + context);
    }

    /**
     * @param context 待办事项内容
     */
    public void addSpecialItem(String context) {
        Specialtodolistitem item = new Specialtodolistitem(context);
        item.setId(items.size() + 1);  // 简单分配ID
        items.add(item);
        System.out.println("已添加特殊待办事项: " + context);
    }

    /**
     * 获取指定索引的待办事项
     * @param index 待办事项索引
     * @return 待办事项对象，索引无效时返回null
     */
    public Todolistitem getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    /**
     * 获取所有待办事项
     * @return 待办事项列表
     */
    public ArrayList<Todolistitem> getItems() {
        return items;
    }

    /**
     * 切换指定待办事项的状态
     * @param index 待办事项索引
     */
    public void toggleItemState(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).shift();
            System.out.println("已切换事项状态: " + items.get(index).getContext());
        } else {
            System.out.println("索引无效!");
        }
    }

    /**
     * 删除指定待办事项
     * @param index 待办事项索引
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            Todolistitem removed = items.remove(index);
            System.out.println("已删除待办事项: " + removed.getContext());
        } else {
            System.out.println("索引无效!");
        }
    }

    /**
     * 获取待办事项数量
     * @return 待办事项总数
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * 显示列表所有待办事项
     */
    public void displayItems() {
        System.out.println("\n=== " + title + " (ID: " + id + ") ===");
        System.out.println("创建时间: " + creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("待办事项 (" + items.size() + " 个):");

        if (items.isEmpty()) {
            System.out.println("  暂无待办事项");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Todolistitem item = items.get(i);
                System.out.println("  " + (i + 1) + ". " + item.toString());
            }
        }
        System.out.println("======================");
    }

    /**
     * 输出列表基本信息
     * @return 格式化的列表信息
     */
    @Override
    public String toString() {
        String timeStr = creationTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "待办列表 [ID: " + id + ", 标题: " + title + ", 创建时间: " + timeStr + ", 事项数: " + items.size() + "]";
    }
}
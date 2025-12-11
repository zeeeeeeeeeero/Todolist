package com.zero.todolist;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 主程序类
 * 提供待办列表系统的用户界面和主逻辑
 */
public class Menu {
    private static Stack<Runnable> menu = new Stack<>();  // 菜单栈，实现菜单导航
    private static ScannerReader scannerReader = new ScannerReader();  // 输入读取器
    private static ArrayList<Todolist> obj_list = new ArrayList<>();  // 存储所有待办列表
    private static Todolist currentList = null;  // 当前操作的待办列表
    private static File file = new File(".\\resources\\DATA\\data.json");

    /**
     * 主菜单
     * 显示系统主选项
     */
    private static void mainMenu() {
        System.out.println("\n=== ToDoList 主菜单 ===");
        System.out.println("1. 查看所有待办列表");
        System.out.println("2. 创建新待办列表");
        System.out.println("3. 选择待办列表");
        System.out.println("4. 管理当前列表");
        System.out.println("0. 退出系统");
        System.out.print("请选择操作: ");

        int choice = scannerReader.getNextInt(0, 4);
        switch (choice) {
            case 0:
                clearStack();
                break;
            case 1:
                displayAllLists();
                menu.push(Menu::mainMenu);
                break;
            case 2:
                createNewList();
                menu.push(Menu::mainMenu);
                break;
            case 3:
                selectList();
                menu.push(Menu::mainMenu);
                break;
            case 4:
                if (currentList != null) {
                    manageCurrentList();
                } else {
                    System.out.println("请先选择一个待办列表!");
                    menu.push(Menu::mainMenu);
                }
                break;
            default:
                System.out.println("无效选择!");
                menu.push(Menu::mainMenu);
                break;
        }
    }

    /**
     * 显示所有待办列表
     */
    private static void displayAllLists() {
        System.out.println("\n=== 所有待办列表 ===");
        if (obj_list.isEmpty()) {
            System.out.println("暂无待办列表");
        } else {
            for (int i = 0; i < obj_list.size(); i++) {
                Todolist list = obj_list.get(i);
                System.out.println((i + 1) + ". " + list.toString());
            }
        }
    }

    /**
     * 创建新待办列表
     */
    private static void createNewList() {
        System.out.println("\n=== 创建新待办列表 ===");
        System.out.print("请输入列表标题 (直接回车使用默认标题): ");
        String title = scannerReader.getNextString();

        Todolist newList;
        if (title.trim().isEmpty()) {
            newList = new Todolist();
        } else {
            newList = new Todolist(title);
        }

        obj_list.add(newList);
        currentList = newList;  // 将新创建的列表设为当前列表
        System.out.println("已创建并选择新列表: " + newList.getTitle());
    }

    /**
     * 选择待办列表
     */
    private static void selectList() {
        System.out.println("1. 选择内存中的待办列表");
        System.out.println("2. 选择文件中的待办列表");
        System.out.println("请选择操作:");
        int choice = scannerReader.getNextInt(0, obj_list.size());
        switch (choice) {
            case 1:
                if (obj_list.isEmpty()) {
                    System.out.println("暂无待办列表，请先创建一个!");
                    return;
                }

                displayAllLists();
                System.out.print("请选择列表编号: ");
                int choice2 = scannerReader.getNextInt(0, obj_list.size());

                if (choice2 > 0 && choice2 <= obj_list.size()) {
                    currentList = obj_list.get(choice2 - 1);
                    System.out.println("已选择列表: " + currentList.getTitle());
                } else {
                    System.out.println("无效选择!");
                }
                break;
            case 2:

            default:
                System.out.println("无效选择!");
                menu.push(Menu::manageCurrentList);
                break;
        }
    }

    /**
     * 管理当前选中的列表
     */
    private static void manageCurrentList() {
        System.out.println("\n=== 管理列表: " + currentList.getTitle() + " ===");
        System.out.println("1. 查看列表详情");
        System.out.println("2. 添加普通待办事项");
        System.out.println("3. 添加特殊待办事项");
        System.out.println("4. 切换事项状态");
        System.out.println("5. 删除待办事项");
        System.out.println("6. 检查事项是否超时");
        System.out.println("7. 将列表存储至本地");
        System.out.println("0. 返回主菜单");
        System.out.print("请选择操作: ");

        int choice = scannerReader.getNextInt(0, 7);
        switch (choice) {
            case 0:
                menu.pop();
                break;
            case 1:
                currentList.displayItems();
                menu.push(Menu::manageCurrentList);
                break;
            case 2:
                addItem(false);
                menu.push(Menu::manageCurrentList);
                break;
            case 3:
                addItem(true);
                menu.push(Menu::manageCurrentList);
                break;
            case 4:
                toggleItemState();
                menu.push(Menu::manageCurrentList);
                break;
            case 5:
                removeItem();
                menu.push(Menu::manageCurrentList);
                break;
            case 6:
                checkItemTimeout();
                menu.push(Menu::manageCurrentList);
                break;
            case 7:
                saveList();
                menu.push(Menu::manageCurrentList);
                break;
            default:
                System.out.println("无效选择!");
                menu.push(Menu::manageCurrentList);
                break;
        }
    }

    /**
     * 向当前列表添加待办事项
     *
     * @param isSpecial 是否为特殊待办事项
     */
    private static void addItem(boolean isSpecial) {
        System.out.print("请输入待办事项内容: ");
        String context = scannerReader.getNextString();

        if (isSpecial) {
            System.out.println("请输入待办持续时间(天): ");
            int temp = scannerReader.getNextInt();
            currentList.addSpecialItem(context, temp);
        } else {
            currentList.addItem(context);
        }
    }

    /**
     * 切换待办事项状态
     */
    private static void toggleItemState() {
        if (currentList.getItemCount() == 0) {
            System.out.println("当前列表为空，无法切换状态!");
            return;
        }

        currentList.displayItems();
        System.out.print("请选择要切换状态的事项编号: ");
        int choice = scannerReader.getNextInt();

        if (choice > 0 && choice <= currentList.getItemCount()) {
            currentList.toggleItemState(choice - 1);
        } else {
            System.out.println("无效选择!");
        }
    }

    /**
     * 删除待办事项
     */
    private static void removeItem() {
        if (currentList.getItemCount() == 0) {
            System.out.println("当前列表为空，无法删除!");
            return;
        }

        currentList.displayItems();
        System.out.print("请选择要删除的事项编号: ");
        int choice = scannerReader.getNextInt();

        if (choice > 0 && choice <= currentList.getItemCount()) {
            currentList.removeItem(choice - 1);
        } else {
            System.out.println("无效选择!");
        }
    }

    /**
     * 检查待办事项是否超时
     */
    private static void checkItemTimeout() {
        if (currentList.getItemCount() == 0) {
            System.out.println("当前列表为空，无法检查!");
            return;
        }

        currentList.displayItems();
        System.out.print("请选择要检查超时的事项编号: ");
        int choice = scannerReader.getNextInt(1, currentList.getItemCount());

        boolean isTimeout = currentList.checkItem(choice - 1);
        System.out.println("该事项" + (isTimeout ? "已超时" : "未超时"));
    }

    /**
     * 用于保存待办列表到本地
     */
    private static void saveList() {

    }

    /**
     * 清空菜单栈
     * 用于退出程序
     */
    public static void clearStack() {
        while (!menu.isEmpty()) {
            menu.pop();
        }
        System.out.println("正在退出程序...");
    }
}

package hashTable;

import java.util.Scanner;

public class TestEmployeeHashTable {

    public static void main(String[] args) {

        EmployeeHashTable employeeHashTable = new EmployeeHashTable(7);

        String key;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:    添加employee");
            System.out.println("list:   显示employee");
            System.out.println("find:   查找employee");
            System.out.println("delete: 删除employee");
            System.out.println("exit:   退出系统");
            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入录入员工的id");
                    int id = scanner.nextInt();
                    System.out.println("输入录入员工的name");
                    String name = scanner.next();
                    Employee employee = new Employee(name, id);
                    employeeHashTable.add(employee);
                    break;
                case "list":
                    employeeHashTable.list();
                    break;
                case "find":
                    System.out.println("输入查找员工的id");
                    id = scanner.nextInt();
                    employeeHashTable.find(id);
                    break;
                case "delete":
                    System.out.println("输入删除员工的id");
                    id = scanner.nextInt();
                    employeeHashTable.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

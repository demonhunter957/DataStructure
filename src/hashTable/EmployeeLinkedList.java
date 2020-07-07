package hashTable;

public class EmployeeLinkedList {

    private Employee head;

    public void add(Employee employee) {
        if (null == head) {
            head = employee;
            return;
        }
        Employee current = head;
        while (null != current.getNext()) {
            current = current.getNext();
        }
        current.setNext(employee);
    }

    public void list(int listNumber) {
        if (null == head) {
            System.out.println("第" + listNumber + "条链表为空");
            return;
        }
        System.out.println("第" + listNumber + "条链表信息： ");
        Employee current = head;
        while (true) {
            System.out.print("===> 员工ID： " + current.getId() + "员工名： " + current.getName());
            if (null == current.getNext()) {
                break;
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public void find(int id) {
        if (null == head) {
            System.out.println("没有此员工数据");
            return;
        }
        Employee current = head;
        while (true) {
            if (id == current.getId()) {
                System.out.println("员工的Id:" + current.getId() + " 员工姓名： " + current.getName());
                break;
            }
            if (null == current.getNext()) {
                System.out.println("没有此员工数据...");
                break;
            }
            current = current.getNext();
        }
    }

    public void delete(int id) {
        if (null == head) {
            System.out.println("没有此员工数据");
            return;
        }
        Employee current = head;
        while (true) {
            if (null == current.getNext()) {
                System.out.println("没有此员工数据...");
                break;
            }
            if(id == current.getId()){
                head = current.getNext();
                break;
            }
            if (id == current.getNext().getId()) {
                Employee temp = current.getNext().getNext();
                current.setNext(temp);
                break;
            }
            current = current.getNext();
        }
    }
}

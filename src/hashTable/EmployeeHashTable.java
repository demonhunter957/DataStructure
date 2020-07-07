package hashTable;

public class EmployeeHashTable {

    private EmployeeLinkedList[] employeeLinkedLists;

    private Integer size;

    public EmployeeHashTable(Integer size) {
        this.employeeLinkedLists = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
        this.size = size;
    }

    public void add(Employee employee) {
        int id = employee.getId();
        int whichList = hashFunction(id);
        employeeLinkedLists[whichList].add(employee);
    }

    public void find(int id){
        int whichList = hashFunction(id);
        employeeLinkedLists[whichList].find(id);
    }

    public void delete(int id){
        int whichList = hashFunction(id);
        employeeLinkedLists[whichList].delete(id);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list(i);
        }
    }

    private int hashFunction(int id) {
        return id % size;
    }
}

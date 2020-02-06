package circleLinkedList;


public class CircleSinglyLinkedList {

    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    // num为参与游戏的小孩个数
    public void add (int num){
        if (num < 1){
            return;
        }
        Boy current = new Boy();
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if ( i == 1){
                first = boy;
                boy.setNext(first);
                current = boy;
            }else{
                current.setNext(boy);
                boy.setNext(first);
                current = boy;
            }
        }
    }

    // 遍历当前的环形链表
    public void show() {
        if ( null == first){ //表示当前环形链表无数据
            return;
        }
        Boy current = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", current.getId());
            if (current.getNext() == first){
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * Josephus问题 计算小孩出圈的顺序
     * @param startNo 从第几个小孩开始数数
     * @param countNum 数几个数
     * @param nums 参与游戏小孩的个数
     */
    public void countBoy(int startNo, int countNum, int nums) {
        add(nums);
        // 创建辅助指针helper
        Boy helper = first;
        //helper需要指向first的前一个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first和helper移动startNo - 1次 （如果从第3个小孩开始数，就移动2次）
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时移动 countNum - 1 次 （因为报数是从自己开始的）
        //循环操作，直到圈中只有一个节点
        while (true){
            if(helper == first) {
               break;
            }
            for (int i = 0; i <countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的小孩就是要出圈的小孩
            System.out.printf("出圈的小孩是%d\n", first.getId());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩是%d", first.getId());
    }
}

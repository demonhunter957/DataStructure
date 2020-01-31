/**
 * 数组模拟环形队列
 */
public class CircleArray {

    private int maxSize;

    private int front; //front指向队列中的第一个元素

    private int rear; //rear指向队列的最后一个元素的后一个位置

    private int[] array;

    public CircleArray (int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //向队列添加数据
    public void addQueue(int n){
        if (isFull()){
            System.err.println("队列已满，无法添加数据");
            return;
        }
        array[rear] = n;
        //将rear后移一位再取模
        rear = (rear + 1) % maxSize;
    }

    //从队列种获取数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法获取数据");
        }
        int result = array[front];
        //将front后移一位再取模
        front = (front + 1) % maxSize;
        return result;
    }

    // 求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

}

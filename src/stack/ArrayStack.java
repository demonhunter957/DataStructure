package stack;

/**
 * 数组模拟栈
 */
public class ArrayStack {
    private int maxSize;

    private int[] stack;

    private int top =-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1 ;
    }

    //入栈
    public void push(int i){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top ++;
        stack[top] = i;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("栈空");
            throw new RuntimeException("栈空，没有数据~");
        }
        int result = stack[top];
        top--;
        return result;
    }

    //显示栈的情况[遍历栈]，遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据~~~");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}

package stack;

public class CalculatorStack {
    private int maxSize;

    private char[] stack;

    private int top =-1;

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new char[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }


    public boolean isEmpty(){
        return top == -1 ;
    }

    //入栈
    public void push(char i){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top ++;
        stack[top] = i;
    }

    //显示栈顶数据
    public char peek(){
        return stack[top];
    }

    //出栈
    public char pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据~");
        }
        char result = stack[top];
        top--;
        return result;
    }
    //返回运算符的优先级，返回的数字越大优先级越高

    public static int priority(char input){
        if (input == '+' || input == '-'){
            return 0;
        }else if (input == '*' || input == '/'){
            return 1;
        }else{
            return -1;
        }
    }

    //判断是不是一个运算符
    public static boolean isOperator(char input){
        return input == '+' || input == '-' || input == '*' || input == '/';
    }

    //计算
    public static int calculate(int num1, int num2, char operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}

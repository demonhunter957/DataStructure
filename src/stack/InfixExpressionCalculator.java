package stack;

/**
 * 中缀表达式计算器
 *  这个程序遗留一个char int转换计算的问题
 */
public class InfixExpressionCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("7*2"));
//        System.out.println("7-2".length());
    }

    public static int calculate (String expression){
        //创建两个stack，一个存放数，一个存放运算符
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operatorStack = new CalculatorStack(10);
        int index = 0;
        char ch;
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        while (true){
            ch = expression.substring(index, index+1).charAt(0);
            if (CalculatorStack.isOperator(ch)){ //如果扫描到的是运算符
                if (!operatorStack.isEmpty()){ //存放运算符的栈不为空
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符, 就需要从数栈中 pop 出两个数,
                    //再从符号栈中 pop 出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (CalculatorStack.priority(ch) <= CalculatorStack.priority(operatorStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = CalculatorStack.calculate(num1, num2, operatorStack.pop());
                        numStack.push((char) result);
                    }else{//如果当前的操作符的优先级大于栈中的操作符，就把运算符放入符号栈
                        operatorStack.push(ch);
                    }
                }else { //存放运算符的栈为空就放入运算符栈
                    operatorStack.push(ch);
                }
            }else { //如果扫描到的是数字就直接放入数字栈
                numStack.push(ch);
            }

            index ++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中 pop 出相应的数和符号，并运算
        while(true) {
            if(operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            result = CalculatorStack.calculate(num1, num2, operatorStack.pop());
            numStack.push((char) result);
        }
        return numStack.pop();
    }
}

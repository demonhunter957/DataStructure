package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式（后缀表达式）计算器 + 将中缀表达式转化成后缀表达式
 * (3+4)*5-6 => 3 4 + 5 * 6 -
 * 4*5-8+60+8/2 => 4 5 * 8 - 60 + 8 2 / +
 */
public class ReversePolishNotationCalculator {
    public static void main(String[] args) {
        List<String> strings = convertToList("1+((2+3)*4)-5");
        System.out.println(strings); //[(, 3, +, 4, ), *, 5, -, 6]
        List<String> strings1 = parseSuffixExpression(strings);
        System.out.println(strings1); //[1, 2, 3, +, 4, *, +, 5, -]

        System.out.println(calculate("1 2 3 + 4 * + 5 -"));
//        System.out.println(calculate("3 4 + 5 * 6 -"));
    }

    //后缀表达式计算
    public static int calculate(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = Arrays.asList(split);
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")){//如果匹配到多位数直接将数入栈
                stack.push(item);
            }else{ //如果匹配到运算符就将栈顶跟次栈顶的两个数出栈，按照：次栈顶-运算符-栈顶 进行运算，并将结果入栈
                int result;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+")){
                    result = num2 + num1;
                }else if (item.equals("-")){
                    result = num2 - num1;
                }else if (item.equals("*")){
                    result = num2 * num1;
                }else if (item.equals("/")){
                    result = num2 / num1;
                }else {
                    throw new RuntimeException("运算符不正确");
                }
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }

    //将中缀表达式转化成后缀表达式
    public static List<String> parseSuffixExpression(List<String> infixExpressionList){
        Stack<String> s1 = new Stack<>(); // 符号栈
        List<String> s2 = new ArrayList<>(); // 储存中间结果的 Lists2
        for (String item : infixExpressionList) {

            if (item.matches("\\d+")){ //如果是一个数，加入 s2
                s2.add(item);
            }else if (item.equals("(")) { //如果是左括号，加入s1
                s1.push(item);
            }else if (item.equals(")")) {//如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();// 将 ( 弹出s1栈，消除小括号
            }else { //如果是运算符
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，循环比较
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ) {
                    s2.add(s1.pop());
                }
                //将运算符入栈
                s1.push(item);
            }
        }
        //将 s1 中剩余的运算符依次弹出并加入 s2
        while (!s1.empty()){
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中缀表达式字符串转成List<String>
    public static List<String> convertToList(String infixExpression){
        List<String> list = new ArrayList<>();
        int index = 0;
        String str;
        char ch;
        while (index < infixExpression.length()){
            ch = infixExpression.charAt(index);
            if (ch < 48 || ch > 57){ //如果ch不是数字，就直接加到list中
                list.add(ch + "");
                index ++;
            }else{ //如果ch是数字，需要考虑多位数的问题
                str = "";
                while(index < infixExpression.length() && infixExpression.charAt(index) >= 48 && (ch=infixExpression.charAt(index)) <= 57){
                    str += ch;
                    index ++;
                }
                list.add(str);
            }
        }
        return list;
    }


}

class Operation{

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                break;
        }
        return result;
    }
}

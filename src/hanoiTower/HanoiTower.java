package hanoiTower;

public class HanoiTower {

    public static void main(String[] args) {
        printStep(3, "塔1", "塔2", "塔3");
    }

    /*
     * 打印汉诺塔的圆盘移动过程
     * 把所有圆盘从A 移动到 C
     */
    public static void printStep(int num, String a, String b, String c){
        if (1 == num){
            System.out.println("第1个圆盘: " + a + "->" + c);
        }else {
            //把n-1个圆盘从A移动到B
            printStep(num -1 , a, c, b);
            System.out.println("第"+num+"个圆盘: " + a + "->" + c);
            //把n-1个圆盘从B移动到C
            printStep(num-1, b, a, c);
        }
    }
}

package recursion;


public class EightQueen {

    int max = 8;

    //定义数组 array, 保存皇后放置位置的结果,比如 arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];

    private static int count;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.put(0);
        System.out.printf("一共有%d种解法", count);
    }

    //放置第n个皇后
    private void put(int n){
        if (n == max){ //如果n ==8，就说已经放置好了8个皇后
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i; //先尝试把这个皇后放到当前这行的第一列
            if (judge(n)){
                put(n + 1); //如果不冲突就放下一个皇后
            }
            //如果冲突，则上面个if没进去，回到for循环，i+1，把皇后放到当前这行的下一列
        }
    }

    //查看当我们放置第 n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    // true表示不冲突,false表示冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]表示放置的第n个皇后跟前面已放置的皇后在同一列
            // Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示放置的第n个皇后跟前面已放置的皇后在同一斜行
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

package sort;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {3, 9, -1, 10, 2};
        optimalBubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void simpleBubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void optimalBubbleSort(int[] array) {
        int temp;
        boolean flag = false; //表示某一轮排序是否进行了交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}

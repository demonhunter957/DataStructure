package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 1, -1, 10, 2};
//        simpleInsertSort(array);
        optimalInsertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void simpleInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];// 将array[insertIndex]后移
                insertIndex--;
            }
            array[insertIndex + 1] = insertValue;
        }
    }

    public static void optimalInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];//将array[insertIndex]后移
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }
        }
    }
}

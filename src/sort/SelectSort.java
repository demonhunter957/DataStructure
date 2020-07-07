package sort;


import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] array = {3, 9, -1, 10, 2};


        optimalSelectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void simpleSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
    }

    public static void optimalSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

}

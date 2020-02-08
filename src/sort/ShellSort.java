package sort;


import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    //交换法希尔排序
    public static void shellSort1(int[] arr){
        int temp;
        for (int gap = arr.length/2; gap >0 ; gap/= 2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 ; j-= gap) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }


}

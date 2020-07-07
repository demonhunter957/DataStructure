package search;


import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(Arrays.toString(fib()));
        System.out.println(fibSearch(arr, 10));
    }

    //创建一个长度20的斐波那契数组
    public static int[] fib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int fibSearch(int[] arr, int findValue) {

        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid;
        int[] f = fib();

        while (high > f[k] - 1) { //while 循环结束后 k=5
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]); // temp=[1, 8, 10, 89, 1000, 1234, 0, 0]

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high]; //  temp=[1, 8, 10, 89, 1000, 1234, 1234, 1234]
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;

            if (findValue < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (findValue > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}

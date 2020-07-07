package search;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 10, 10, 10, 89, 1234};
//        int resultIndex = search(123, 0, arr.length, arr);
//        System.out.println(resultIndex);
        ArrayList<Integer> result = search2(10, 0, arr.length, arr);
        System.out.println(result);
    }

    public static int search(int findValue, int left, int right, int[] arr) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (midValue < findValue) {
            return search(findValue, left + 1, right, arr);
        } else if (midValue > findValue) {
            return search(findValue, left, right - 1, arr);
        } else {
            return mid;
        }
    }

    /*
     * 如果查找的结果在集合中不止有一个，则返回所有的下标
     */
    public static ArrayList<Integer> search2(int findValue, int left, int right, int[] arr) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (midValue < findValue) {
            return search2(findValue, left + 1, right, arr);
        } else if (midValue > findValue) {
            return search2(findValue, left, right - 1, arr);
        } else {
            ArrayList<Integer> resultList = new ArrayList<>();
            resultList.add(mid);

            //向左扫描
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findValue) {
                resultList.add(temp);
                temp -= 1;
            }

            //向右扫描
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findValue) {
                resultList.add(temp);
                temp += 1;
            }
            return resultList;
        }
    }

}

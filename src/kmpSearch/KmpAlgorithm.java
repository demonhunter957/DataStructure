package kmpSearch;

import java.util.Arrays;

public class KmpAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str3 = "BBC";

        int[] next = kmpNext(str2); //[0, 0, 0, 0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for(int i = 0, j = 0; i < str1.length(); i++) {
            while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) {
                return i - j + 1;
            }
        }
        return  -1;
    }
    //获取一个字符串的部分匹配表
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串只有一个字符，它的部分匹配值肯定为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}

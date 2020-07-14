package kmpSearch;

public class ViolenceMatch {

    public static void main(String[] args) {
        String s1 = "ABACDABCDBA";
        String s2 = "ABC";
        String s3 = "ABCA";
        System.out.println(violentMatch(s1, s2));
        System.out.println(violentMatch(s1, s3));
    }

    public static int violentMatch(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (char1[i] == char2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }
}


public class SparseArray {

    public static void main(String[] args) {
        //创建一个11*11的原始二位数组模拟五子棋棋盘，0表示没有棋子，1表示黑子，2表示白字
        int row = 11;
        int column = 11;
        int chessArr1[][] = new int[row][column];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("原始的二维数组~~");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.print(anInt+ "\t");
            }
            System.out.println();
        }

        //将原始的二位数组转成稀疏数组
        //遍历原始二维数组，得到非0数据的个数
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt != 0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组,行数为sum+1,列数为3，
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;
        //遍历原始数组，将对应的数据放到稀疏数组中
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("对应的稀疏数组~~");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        //将稀疏数组恢复成原始数组
        int[][] chessArr2 = new int[row][column];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("由稀疏数组恢复的二位数组~~");
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.print(anInt+ "\t");
            }
            System.out.println();
        }
    }
}

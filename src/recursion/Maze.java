package recursion;

/**
 * 递归解决迷宫问题
 */
public class Maze {

    public static void main(String[] args) {

        //创建一个迷宫 1表示墙
        int[][] map = new int[8][7];
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 || j == 0 || i ==7 || j == 6){
                    map[i][j] = 1;
                }
            }
        }
        printMap(map);
        setWay(map, 1, 1);
        System.out.println("走完迷宫后的map");
        printMap(map);
    }

    //使用递归走迷宫
    // i j 表示出发点的坐标
    // 0 表示该点没有被走过；1表示墙；2表示该点可以走；3表示该点已走过但走不通
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){ //已经找到通路
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2; //假设这点可以走
                //拟定找路的策略下->右->上-=>左
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){
                    return true;
                }else if (setWay(map, i-1, j)){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else { //如果该点不为0就说明走不通
                return false;
            }
        }
    }

    public static void printMap(int[][] map){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
    }
}

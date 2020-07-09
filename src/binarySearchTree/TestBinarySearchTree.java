package binarySearchTree;


public class TestBinarySearchTree {

    public static void main(String[] args) {

        MyBinarySearchTree binarySearchTree = new MyBinarySearchTree();
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};
        for (int i : array) {
            binarySearchTree.add(new MyNode(i));
        }
        System.out.println("删除前。。。。");
        binarySearchTree.infixOrderList();

        binarySearchTree.delete(2);
        binarySearchTree.delete(5);
        binarySearchTree.delete(9);
        binarySearchTree.delete(12);
        binarySearchTree.delete(7);
        binarySearchTree.delete(3);
        binarySearchTree.delete(1);
        binarySearchTree.delete(10);
        System.out.println("删除后。。");
        binarySearchTree.infixOrderList();

//        System.out.println(binarySearchTree.search(9));
//        System.out.println(binarySearchTree.searchParentNode(3));

    }
}

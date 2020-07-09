package binarySearchTree;

public class TestAvlTree {

    public static void main(String[] args) {
        MyBinaryTree binarySearchTree = new MyBinaryTree();
//        int[] array = {4, 3, 6, 5, 7, 8};
        int[] array = {10, 11, 7, 6, 8, 9};
        for (int i : array) {
            binarySearchTree.add(new MyNode(i));
        }
        binarySearchTree.infixOrderList();
        System.out.println("binarySearchTree 的高度为：" + binarySearchTree.getRoot().height());
        System.out.println(binarySearchTree.getRoot());

        System.out.println("binarySearchTree 左子树的高度为：" + binarySearchTree.getRoot().leftHeight());
        System.out.println("binarySearchTree 右子树的高度为：" + binarySearchTree.getRoot().rightHeight());
    }
}

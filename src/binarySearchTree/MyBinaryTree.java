package binarySearchTree;

public class MyBinaryTree {

    private MyNode root;

    public MyNode getRoot() {
        return root;
    }

    public void setRoot(MyNode root) {
        this.root = root;
    }

    public void add(MyNode node) {
        if (null == root) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //按照结点的value 查找结点
    public MyNode search(int value) {
        if (null == root) {
            return null;
        }
        return root.search(value);
    }

    //按照结点的value 查找该结点的父节点
    public MyNode searchParentNode(int value) {
        if (null == root) {
            return null;
        }
        return root.searchParent(value);
    }

    //按照中序打印此树
    public void infixOrderList() {
        if (null != root) {
            root.infixOrderList();
        } else {
            System.out.println("empty tree");
        }
    }

    //根据结点的value 删除某个结点
    public void delete(int value) {
        if (null == root) {
            return;
        }
        MyNode targetNode = search(value);
        if (null == targetNode) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }

        MyNode parent = searchParentNode(value);

        if (null == targetNode.getLeft() && null == targetNode.getRight()) { //如果要删除的结点是叶子结点
            //判断targetNode是parentNode的左子结点还是右子结点
            if (targetNode == parent.getLeft()) {
                parent.setLeft(null);
            } else if (targetNode == parent.getRight()) {
                parent.setRight(null);
            }
        } else if (null != targetNode.getLeft() && null != targetNode.getRight()) {  //如果删除的结点有左右两个子树
            MyNode min = findMin(targetNode.getRight());
            targetNode.setValue(min.getValue());
        } else { //如果要删除的结点只有一个子树
            if (null != targetNode.getLeft()) { //要删除的结点只有一个左子树
                if (null != parent) {
                    if (targetNode == parent.getLeft()) {
                        parent.setLeft(targetNode.getLeft());
                    } else if (targetNode == parent.getRight()) {
                        parent.setRight(targetNode.getLeft());
                    }
                } else { // 当删除的结点为root，且root只有左子树。注意这种情况！！
                    this.setRoot(targetNode.getLeft());
                }
            } else { // 要删除的结点只有一个右子树
                if (null != parent) {
                    if (targetNode == parent.getLeft()) {
                        parent.setLeft(targetNode.getRight());
                    } else if (targetNode == parent.getRight()) {
                        parent.setRight(targetNode.getRight());
                    }
                } else { // 当删除的结点为root，且root只有右子树。同#L82，注意这种情况！！
                    this.setRoot(targetNode.getRight());
                }

            }
        }
    }

    private MyNode findMin(MyNode node) {
        MyNode temp = node;
        while (null != temp.getLeft()) {
            temp = temp.getLeft();
        }
        delete(temp.getValue());
        return temp;
    }
}
package binarySearchTree;

public class MyNode {

    private int value;

    private MyNode left;

    private MyNode right;

    public MyNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                '}';
    }

    public void add(MyNode node) {
        if (null == node) {
            return;
        }
        if (node.getValue() < value) {
            if (null == left) {
                setLeft(node);
            } else {
                left.add(node);
            }
        } else {
            if (null == right) {
                setRight(node);
            } else {
                right.add(node);
            }
        }

        //当添加完一个结点后，如果(右子树的高度-左子树的高度) > 1 就进行左旋转
        if (rightHeight() - leftHeight() > 1){
            //如果它的右子树的左子树高度大于它右子树的右子树高度
            //那么就 先对当前节点的右子结点进行右旋转
            //再对当前节点就行左旋转
            if (null != right && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
            }
            leftRotate();
            return; //必须要！！！！
        }

        //当添加完一个结点后，如果(左子树的高度-右子树的高度) > 1 就进行右旋转
        if (leftHeight() - rightHeight() > 1){
            //如果它的左子树的右子树高度大于它左子树的左子树高度
            //那么就 先对当前节点的左结点进行左旋转
            //再对当前节点就行右旋转
            if (null != left && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    public MyNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (null == left) {
                return null;
            }
            return left.search(value);
        } else {
            if (null == right) {
                return null;
            }
            return right.search(value);
        }
    }

    public MyNode searchParent(int value) {
        if (null != left && value == left.getValue() ||
                null != right && value == right.getValue()) {
            return this;
        } else {
            if (value < this.value && null != left) {
                return left.searchParent(value);
            } else if (value >= this.value && null != right) {
                return right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void infixOrderList() {
        if (null != left) {
            left.infixOrderList();
        }
        System.out.println(this);
        if (null != right) {
            right.infixOrderList();
        }
    }

    //返回当前结点为根节点，树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //返回当前结点为根节点，左子树的高度
    public int leftHeight() {
        if (null == left) {
            return 0;
        }
        return left.height();
    }

    //返回以当前结点为根节点了，右子树的高度
    public int rightHeight() {
        if (null == right) {
            return 0;
        }
        return right.height();
    }

    private void leftRotate() {
        //1) 用当前结点的值创建新结点
        //2) 把新节点的左子树设置成当前结点的左子树
        //3) 把新节点的右子树设置成当前结点右子树的左子树
        //4) 把当前结点的值替换成右子结点的值
        //5) 把当前结点的右子树设置成当前结点右子树的右子树
        //6) 把当前结点的左子树（左子节点）设置成新结点
        MyNode newNode = new MyNode(value);
        newNode.setLeft(left);
        newNode.setRight(right.left);
        value = right.getValue();
        this.setRight(right.right);
        this.setLeft(newNode);
    }

    private void rightRotate() {
        MyNode newNode = new MyNode(value);
        newNode.setRight(right);
        newNode.setLeft(left.right);
        value = left.getValue();
        this.setLeft(left.left);
        this.setRight(newNode);
    }

}
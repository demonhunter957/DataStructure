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
        if (node.getValue() < this.getValue()) {
            if (null == this.getLeft()) {
                this.setLeft(node);
            } else {
                this.getLeft().add(node);
            }
        } else {
            if (null == this.getRight()) {
                this.setRight(node);
            } else {
                this.getRight().add(node);
            }
        }
    }

    public MyNode search(int value) {
        if (value == this.getValue()) {
            return this;
        } else if (value < this.getValue()) {
            if (null == this.getLeft()) {
                return null;
            }
            return this.getLeft().search(value);
        } else if (value > this.getValue()) {
            if (null == this.getRight()) {
                return null;
            }
            return this.getRight().search(value);
        }
        return null;
    }

    public MyNode searchParent(int value) {
        if (null != this.getLeft() && value == this.getLeft().getValue() ||
                null != this.getRight() && value == this.getRight().getValue()) {
            return this;
        } else {
            if (value < this.getValue() && null != this.getLeft()) {
                return this.getLeft().searchParent(value);
            } else if (value >= this.getValue() && null != this.getRight()) {
                return this.getRight().searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void infixOrderList() {
        if (null != this.getLeft()) {
            this.getLeft().infixOrderList();
        }
        System.out.println(this);
        if (null != this.getRight()) {
            this.getRight().infixOrderList();
        }
    }

}
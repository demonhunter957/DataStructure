package tree;

public class HeroNode {

    private String name;

    private int id;

    private HeroNode right;

    private HeroNode left;

    public HeroNode(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    //前序遍历
    public void prefixOrder() {
        System.out.println(this);
        if (null != this.getLeft()) {
            this.getLeft().prefixOrder();
        }
        if (null != this.getRight()) {
            this.getRight().prefixOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (null != this.getLeft()) {
            this.getLeft().infixOrder();
        }
        System.out.println(this);
        if (null != this.getRight()) {
            this.getRight().infixOrder();
        }
    }

    //后序遍历
    public void postfixOrder() {
        if (null != this.getLeft()) {
            this.getLeft().postfixOrder();
        }
        if (null != this.getRight()) {
            this.getRight().postfixOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode prefixOrderSearch(int id) {
        if (id == this.getId()) {
            return this;
        }
        HeroNode result = null;
        if (null != this.getLeft()) {
            result = this.getLeft().prefixOrderSearch(id);
        }
        if (null != result) {
            return result;
        }
        if (null != this.getRight()) {
            result = this.getRight().prefixOrderSearch(id);
        }
        return result;
    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {
        HeroNode result = null;
        if (null != this.getLeft()) {
            result = this.getLeft().infixOrderSearch(id);
        }
        if (null != result) {
            return result;
        }
        if (id == this.getId()) {
            return this;
        }
        if (null != this.getRight()) {
            result = this.getRight().infixOrderSearch(id);
        }
        return result;
    }

    //后序查找
    public HeroNode postfixOrderSearch(int id) {
        HeroNode result = null;
        if (null != this.getLeft()) {
            result = this.getLeft().postfixOrderSearch(id);
        }
        if (null != result) {
            return result;
        }
        if (null != this.getRight()) {
            result = this.getRight().postfixOrderSearch(id);
        }
        if (null != result) {
            return result;
        }
        if (id == this.getId()) {
            return this;
        }
        return result;
    }
}

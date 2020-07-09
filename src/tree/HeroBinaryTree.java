package tree;

public class HeroBinaryTree {

    private HeroNode root;

    public HeroBinaryTree(HeroNode root) {
        this.root = root;
    }

    public HeroBinaryTree() {
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void prefix() {
        if (null == root) {
            System.out.println("树为空...");
            return;
        }
        root.prefixOrder();
    }

    //中序遍历
    public void infix() {
        if (null == root) {
            System.out.println("树为空...");
            return;
        }
        root.infixOrder();
    }

    //后序遍历
    public void postfix() {
        if (null == root) {
            System.out.println("树为空...");
            return;
        }
        root.postfixOrder();
    }

    //前序查找
    public HeroNode prefixSearch(int id) {
        if (null == root) {
            System.out.println("树为空...");
            return null;
        }
        return root.prefixOrderSearch(id);
    }

    //中序查找
    public HeroNode infixSearch(int id) {
        if (null == root) {
            System.out.println("树为空...");
            return null;
        }
        return root.infixOrderSearch(id);
    }

    //后序查找
    public HeroNode postfixSearch(int id) {
        if (null == root) {
            System.out.println("树为空...");
            return null;
        }
        return root.postfixOrderSearch(id);
    }
}

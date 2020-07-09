package tree;

public class TreeTest {

    public static void main(String[] args) {

        HeroBinaryTree heroTree = new HeroBinaryTree();

        HeroNode node = new HeroNode("宋江", 1);
        HeroNode node2 = new HeroNode("卢俊义", 2);
        HeroNode node3 = new HeroNode("吴用", 3);
        HeroNode node4 = new HeroNode("公孙胜", 4);
        HeroNode node5 = new HeroNode("关胜", 5);

        node.setLeft(node2);
        node.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        heroTree.setRoot(node);

//        heroTree.prefix();
//        heroTree.infix();
//        heroTree.postfix();

        System.out.println(heroTree.postfixSearch(5));

    }

}

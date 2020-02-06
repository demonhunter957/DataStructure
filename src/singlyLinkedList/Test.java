package singlyLinkedList;


public class Test {

    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode heroNode5 = new HeroNode(5,"关胜", "大刀");
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.add(heroNode);
//        myLinkedList.add(heroNode2);
//        myLinkedList.add(heroNode3);
//        myLinkedList.add(heroNode4);
        myLinkedList.addByOrder(heroNode);
        myLinkedList.addByOrder(heroNode2);
        myLinkedList.addByOrder(heroNode4);
        myLinkedList.addByOrder(heroNode3);
        myLinkedList.addByOrder(heroNode5);
        myLinkedList.list();
//        System.out.println();
//        myLinkedList.update(new HeroNode(2, "卢俊义1111", "玉麒麟111"));
//        myLinkedList.delete(3);
//        myLinkedList.addByOrder(heroNode3);
//        myLinkedList.list();
//        System.out.println(myLinkedList.length());
//        System.out.println(myLinkedList.lastIndex(2));
//        myLinkedList.reverse().list();
        System.out.println();
        myLinkedList.reversePrint();
    }
}

package LinkedList;


import java.util.Stack;

public class MyLinkedList {

    //初始化链表头
    private HeroNode head = new HeroNode();

    private HeroNode getHead(){
        return this.head;
    }


    //添加节点到单向链表,不考虑编号
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表，找到链表最后的节点
        while (true){
            if (null == temp.next ){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //根据编号向链表添加节点，如果有重复就提示
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (null == temp.next){ //temp已经在链表的最后
                break;
            }
            if (temp.next.id > heroNode.id){ //插入的位置在temp之后
                break;
            }
            if (temp.next.id == heroNode.id){ //要插入的节点编号已经在链表中
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("准备插入的英雄的编号%d已经存在了, 不能加入\n", heroNode.id);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点信息
    public void update (HeroNode heroNode){
        if (null == head.next){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (null == temp.next){
                break;
            }
            if (temp.id == heroNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else{
            System.out.println("没有找到需要修改的节点");
        }
    }

    //根据Id删除节点
    public void delete(int id){
        if (null == head.next){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (null == temp.next){
                break;
            }
            if (temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点id%d不存在\n", id);
        }
    }

    //统计链表中节点的个数，head节点不算
    public int length(){
        if (null == head.next){
            return 0;
        }
        HeroNode current = head.next;
        int count = 0;
        while (null != current){
            count++;
            current = current.next;
        }
        return count;
    }

    //显示链表
    public void list(){
        if (null == head.next){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = this.head.next;
        while (true){
            if (null == temp){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //查找单链表中倒数第n个节点（新浪面试题）
    public HeroNode lastIndex(int n){
        if (null == head.next){
            return null;
        }
        if (n <= 0 || n > length()){
            throw new IndexOutOfBoundsException();
        }
        HeroNode temp = head.next;
        for (int i = 0; i < length() - n; i++) { //假设链表有5个节点，要到倒数第2个，就从第1个有效节点向后数3位
            temp = temp.next;
        }
        return temp;
    }

    //单链表的反转（腾讯面试题）
    public MyLinkedList reverse(){
        if (null == head.next || length() == 1){
            return this;
        }
        HeroNode current = head.next;
        HeroNode next;
        MyLinkedList newLinkedList = new MyLinkedList();
        HeroNode reversedHead = newLinkedList.getHead();
        while (null != current){
            next = current.next;
            current.next = reversedHead.next; //将current的下一个节点指向新链表的最前端
            reversedHead.next = current;
            current = next;
        }
        head.next = reversedHead.next;
        return newLinkedList;
    }

    //从尾到头打印链表（百度面试题）
    //方式1，先将单链表反转，参考上面方法
    //方式2,利用stack
    public void reversePrint(){
        if (null == head.next){
            System.out.println("链表为空");
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode current = head.next;
        while (null != current){
            stack.push(current);
            current = current.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}

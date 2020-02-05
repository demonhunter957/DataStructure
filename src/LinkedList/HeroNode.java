package LinkedList;

public class HeroNode {
    public int id;

    public String name;

    public String nickName;

    public HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {

    }

    @Override
    public String toString() {
        return "HeroNode [id=" + id + ", name=" + name + ", nickname=" + nickName + "]";
    }
}

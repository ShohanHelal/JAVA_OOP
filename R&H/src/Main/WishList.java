package Main;

public class WishList implements java.io.Serializable {
    private static final long serialVersionUID = 5L;

    String name;
    int demand = 1;

    public WishList(String name) {
        this.name = name;
    }

    void increaseDemand() {
        demand++;
    }

    void display() {
        System.out.println(name + " || Demand Level : " + demand);
    }
}
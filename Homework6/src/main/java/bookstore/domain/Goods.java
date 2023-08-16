package bookstore.domain;

public abstract class Goods implements IGoods {
    private String id;
    private double price;

    public Goods(String id, double price) {
        this.id = id;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;    }

}

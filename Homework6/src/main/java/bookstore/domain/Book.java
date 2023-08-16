package bookstore.domain;

public class Book extends Goods implements IGoods {

        private String title;
        private String author;

    public Book(String id, String title, String author, double price) {
        super(id, price);
        this.title = title;
        this.author = author;
    }
    @Override
    public void setId(String id) {
        super.setId(id);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }
    @Override
    public String getId() {
        return super.getId();
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public double getPrice() {
        return super.getPrice();
    }
}

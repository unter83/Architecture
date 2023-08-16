package bookstore.data;

import bookstore.domain.Goods;
import bookstore.domain.IGoods;

import java.util.ArrayList;
import java.util.List;

// Класс, реализующий хранилище книг с использованием коллекций
public class BookStore implements BookRepository {
    private List<IGoods> goodies;

    public BookStore() {
        goodies = new ArrayList<>();
    }

    public void add(IGoods book) {
        goodies.add(book);
    }

    public void remove(IGoods book) {
        goodies.remove(book);
    }

    public List<IGoods> getAll() {
        return goodies;
    }
}

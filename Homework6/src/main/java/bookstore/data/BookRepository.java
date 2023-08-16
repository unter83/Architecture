package bookstore.data;

import bookstore.domain.*;

import java.util.List;

public interface BookRepository {

    public void add(IGoods goody);

    public void remove(IGoods goody);
    public List<IGoods> getAll();
}

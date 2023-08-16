package bookstore.presentation;

import bookstore.data.BookRepository;
import bookstore.data.BookStore;
import bookstore.domain.Book;
import bookstore.domain.Goods;
import bookstore.domain.IGoods;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookStore = new BookStore();

        // Добавляем книги в магазин
        IGoods book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        IGoods book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        bookStore.add(book1);
        bookStore.add(book2);

        // Получаем список всех книг в магазине
        List<IGoods> allBooks = bookStore.getAll();
        for (IGoods book : allBooks)
            System.out.println("Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
    }
}
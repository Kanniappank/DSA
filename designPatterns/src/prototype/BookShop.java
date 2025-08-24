package prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
    private String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadBooks() {
        for (int i = 1; i < 10; i++) {
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("Book " + i);
            books.add(b);
        }
    }

    @Override
    public BookShop clone() throws CloneNotSupportedException {
        // Shallow Clone vs Deep Clone in Java:

        // Shallow Clone:
        // - Creates a new object but copies references of member objects
        // - Both original and cloned objects share same references
        // - Changes in one object's members affect the other
        // - Default clone() method performs shallow cloning
        // - Faster but can lead to data inconsistency

        // Deep Clone:
        // - Creates a new object and recursively clones all nested objects
        // - Original and clone have completely independent copies
        // - Changes in one object don't affect the other
        // - Must be implemented manually
        // - More expensive but safer

        // To implement deep clone, we would need to clone each Book object:
        /*
         * @Override
         * public BookShop clone() throws CloneNotSupportedException{
         * BookShop shop = new BookShop();
         * for(Book b: this.getBooks()){
         * Book bookClone = b.clone(); // Assuming Book implements clone()
         * shop.getBooks().add(bookClone);
         * }
         * return shop;
         * }
         */
        BookShop shop = new BookShop();
        for (Book b : this.getBooks()) {
            shop.getBooks().add(b);
        }
        return shop;
    }

    @Override
    public String toString() {
        return "BookShop [shopName=" + shopName + ", books=" + books + "]";
    }
}

package prototype;

public class PrototypeDemo{
    public static void main(String[] args) throws CloneNotSupportedException{

        BookShop bs = new BookShop();
        bs.setShopName("Equim bothers");
        bs.loadBooks();
        
        BookShop bs1 = bs.clone();
        bs.getBooks().remove(2);
        System.out.println(bs);
        bs1.setShopName("New Book Shop");
        System.out.println(bs1);


        
    }    
}

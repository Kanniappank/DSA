package prototype;

public class Book {
    private int bId;
    private String bookName;

    public int getBookId(){
        return bId;
    }

    public void setBookId(int bId){
        this.bId = bId;
    }

    public String getBookName(){
        return bookName;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    @Override
    public String toString(){
        return "Book ID: "+bId+" Book Name: "+bookName;
    }

}

package Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> playList = new SongCollection();
        Iterator<String> songIterator = playList.createIterator();

        while(songIterator.hasNext()){
            System.out.println(songIterator.next());
        }
    }
}

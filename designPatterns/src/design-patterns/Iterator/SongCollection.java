package Iterator;

import java.util.ArrayList;
import java.util.List;

public class SongCollection implements Collection<String>{

    private List<String> songs = new ArrayList<>();

    public SongCollection(){
        songs.add("Song A");
        songs.add("Song B");
        songs.add("Song C");
    }

    @Override
    public Iterator<String> createIterator() {
        return new SongIterator(songs);
    }
    
}

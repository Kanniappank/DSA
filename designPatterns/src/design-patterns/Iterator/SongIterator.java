package Iterator;

import java.util.List;

public class SongIterator implements Iterator<String> {
    private List<String> songs;
    private int index;

    public SongIterator(List<String> songs) {
        this.songs = songs;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < songs.size();
    }

    @Override
    public String next() {
        return songs.get(index++);
    }
    
}

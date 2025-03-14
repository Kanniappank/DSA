package Momento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> state = new ArrayList<>();

    public void push(EditorState state){
        this.state.add(state);
    }
    public EditorState pop(){
        var lastIndex = state.size()-1;
        var lastState = state.get(lastIndex);
        state.remove(lastIndex);
        return lastState;

    }
}

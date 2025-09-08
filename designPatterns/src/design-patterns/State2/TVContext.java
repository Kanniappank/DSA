package State2;

class TVContext {
    private IState currentState;

    public TVContext() {
        currentState = new OffState();
    }

    public void setState(IState state) {
        this.currentState = state;
    }

    public void pressPowerButton(){
        currentState.pressPowerButton(this);
    }

}
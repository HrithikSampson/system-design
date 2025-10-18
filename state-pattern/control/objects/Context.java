package control.objects;

public class Context {
    private State state;

    public Context() {
        this.state = null;
    }
    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        if (state != null) {
            state.handle();
        } else {
            throw new Error("State is not set.");
        }
    }    
}

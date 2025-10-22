;

public class Door {
    private DoorState state;

    public Door() {
        this.state = DoorState.CLOSED;
    }

    public DoorState getState() {
        return state;
    }

    public void setState(DoorState state) {
        this.state = state;
    }
}
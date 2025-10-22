;

public class InternalButton {
    private int floorNumber;
    private boolean isPressed;

    public InternalButton(int floorNumber) {
        this.floorNumber = floorNumber;
        this.isPressed = false;
    }

    public void press() {
        this.isPressed = true;
    }

    public void reset() {
        this.isPressed = false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isPressed() {
        return isPressed;
    }
}
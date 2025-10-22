package elevator;

public class ExternalFloorButton extends Button {
    private int targetFloor;

    public ExternalFloorButton(int targetFloor) {
        super(new ExternalFloorCommand(0, targetFloor));
        this.targetFloor = targetFloor;
    }

    @Override
    public void press() {
        if (!isPressed) {
            isPressed = true;
            submitRequest();
        }
    }

    @Override
    public void submitRequest() {
        command.submitRequest();
    }
}
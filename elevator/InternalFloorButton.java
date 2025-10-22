package elevator;

public class InternalFloorButton extends Button {
    private int targetFloor;

    public InternalFloorButton(int targetFloor) {
        super();
        this.targetFloor = targetFloor;
        this.command = new InternalCarCommand(targetFloor, InternalCarCommand.Type.FLOOR);
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
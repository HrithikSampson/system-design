package elevator;

public class ExternalDirectionButton extends Button {
    private Direction direction;
    public int floorNumber;

    public ExternalDirectionButton(Direction direction) {
        super(new ExternalDirectionCommand(direction, floorNumber));
        this.direction = direction;
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
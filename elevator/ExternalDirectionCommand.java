package elevator;

public class ExternalDirectionCommand implements IButtonCommand {
    private Direction direction;
    private int floor;

    public ExternalDirectionCommand(Direction direction, int floor) {
        this.direction = direction;
        this.floor = floor;
    }

    @Override
    public void submitRequest() {
        // Logic to submit external direction request
    }
}
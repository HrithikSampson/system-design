package elevator;

public class ExternalFloorCommand implements IButtonCommand {
    private int floor;
    private int targetFloor;

    public ExternalFloorCommand(int floor, int targetFloor) {
        this.floor = floor;
        this.targetFloor = targetFloor;
    }

    @Override
    public void submitRequest() {
        // Logic to submit external floor request
    }
}
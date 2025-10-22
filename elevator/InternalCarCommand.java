package elevator;

public class InternalCarCommand extends ButtonCommand {
    private int targetFloor;
    private Type type;

    public InternalCarCommand(int targetFloor, Type type) {
        this.targetFloor = targetFloor;
        this.type = type;
    }

    @Override
    public void submitRequest() {
        // Logic to submit internal car request
    }

    public enum Type {
        FLOOR,
        EMERGENCY,
        DOOR_OPEN,
        DOOR_CLOSE
    }
}
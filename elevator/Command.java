

public class Command {
    private int targetFloor;
    private Direction direction;

    public Command(int targetFloor, Direction direction) {
        this.targetFloor = targetFloor;
        this.direction = direction;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}
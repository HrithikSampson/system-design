

import java.util.List;
import java.util.ArrayList;

public class ElevatorCar {
    private Door door;
    int elevatorId;
    private int floorNumber;
    private Direction direction;
    private InternalButton internalButton;
    private Display internalDisplay;
    private DoorState doorState;
    private List<IObservor> observors;

    public ElevatorCar() {
        this.observors = new ArrayList<>();
        this.doorState = DoorState.CLOSED;
        this.direction = Direction.IDLE;
        
    }

    public void updateCall() {
        for (IObservor observor : observors) {
            observor.update();
        }
    }
    public void addObservor(IObservor observor) {
        this.observors.add(observor);
    }

    public void addRequest(Request request) {
        // Logic to add a new elevator request
        // This could include updating the internal state and notifying observers
    }

    public void changeDirection() {
        // Logic to change elevator direction based on requests
        // This would update the direction field and possibly notify observers
    }

    // Getters and Setters
    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        updateCall(); // Notify observers when floor changes
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        updateCall();
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public Display getInternalDisplay() {
        return internalDisplay;
    }

    public void setInternalDisplay(Display internalDisplay) {
        this.internalDisplay = internalDisplay;
    }

    public DoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
        updateCall(); // Notify observers when door state changes
    }
}

package elevator;

import java.util.List;

public class Building {
    private ElevatorSystem elevatorSystem;
    private List<Request> requests;
    
    

    public Building(int floors, int numberOfCars) {
        this.floors = floors;
        this.elevatorSystem = new ElevatorSystem(numberOfCars, floors);

    }

    
}
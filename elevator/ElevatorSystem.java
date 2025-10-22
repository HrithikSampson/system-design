import java.util.List;
import java.util.ArrayList;;
import java.util.Set;

class ElevatorSystem implements IObservor {
    public List<ElevatorCar> elevatorCars;
    public List<IButtonCommand> commands;
    public Set<Integer> servicedFloors;
    public int numberOfCars;

    public ElevatorSystem(Set<Integer> servicedFloors, int numberOfCars) {
        for(int i = 0; i < numberOfCars; i++) {
            ElevatorCar car = new ElevatorCar(i, servicedFloors);
            elevatorCars.add(car);
            car.addObservor(this);
        }
        
        this.commands = new ArrayList<>();
        this.servicedFloors = servicedFloors;
    }
    public List<ElevatorCar> getElevatorCars() {
        return elevatorCars;
    }
    public List<IButtonCommand> getCommands() {
        return commands;
    }
    public Set<Integer> getServicedFloors() {
        return servicedFloors;
    }
    public void submitCommand(IButtonCommand command) {
        commands.add(command);
    }

}
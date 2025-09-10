package managers;
import managers.strategy.IParkStrategy;
import managers.vehicleManager.VehicleManager;
import managers.VehicleManagerFactory;
import managers.ParkingLotManager;
import dto.VehicleType;
import dto.Vehicle;
import dto.Ticket;
import dto.SlotConfiguration;
import java.util.List;

public class FloorManager {
    private IParkStrategy parkStrategy;
    private int numSlots;
    public final int floorNumber;
    private String parkingLotId;
    private VehicleManagerFactory vehicleManagerFactory;
    private SlotConfiguration slotConfiguration;
    public FloorManager(int floorNumber, int numSlots, String parkingLotId, IParkStrategy parkStrategy) {
        this(floorNumber, numSlots, parkingLotId, parkStrategy, SlotConfiguration.createDefaultConfiguration());
    }
    
    public FloorManager(int floorNumber, int numSlots, String parkingLotId, IParkStrategy parkStrategy, SlotConfiguration slotConfig) {
        this.numSlots = numSlots;
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.vehicleManagerFactory = new VehicleManagerFactory(floorNumber, parkingLotId);
        this.parkStrategy = parkStrategy;
        this.slotConfiguration = slotConfig;
    }

    public void addParkingSpace(VehicleType vehicleType, int slotNumber) {
        getVehicleManager(vehicleType).addParkingSpace(slotNumber);
    }
    private VehicleManager getVehicleManager(VehicleType vehicleType) {
        return vehicleManagerFactory.getVehicleManager(vehicleType);
    }
    
    // Display helper methods
    public int getFreeSlotCount(VehicleType vehicleType) {
        return getVehicleManager(vehicleType).getFreeSlotCount();
    }
    
    public List<Integer> getFreeSlots(VehicleType vehicleType) {
        return getVehicleManager(vehicleType).getFreeSlots();
    }
    
    public List<Integer> getOccupiedSlots(VehicleType vehicleType) {
        return getVehicleManager(vehicleType).getOccupiedSlots();
    }
    
    public Ticket parkVehicle(Vehicle vehicle, ParkingLotManager parkingLotManager) {
        VehicleManager vehicleManager = getVehicleManager(vehicle.vehicleType);
        return vehicleManager.parkVehicle(vehicle, parkingLotId, floorNumber);
    }
    
    public String unparkVehicle(int slotNumber) {
        // Find which vehicle type this slot belongs to
        VehicleType vehicleType = getVehicleTypeForSlot(slotNumber);
        if (vehicleType == null) {
            return "Invalid Ticket";
        }
        
        VehicleManager vehicleManager = getVehicleManager(vehicleType);
        return vehicleManager.unparkVehicle(slotNumber);
    }
    
    private VehicleType getVehicleTypeForSlot(int slotNumber) {
        return slotConfiguration.getVehicleTypeForSlot(slotNumber);
    }
}

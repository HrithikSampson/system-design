package managers.vehicleManager;
import managers.strategy.IParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Slot;
import dto.Ticket;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public abstract class VehicleManager {
    public final int floorNumber;
    public final String parkingLotId;
    protected IParkStrategy vehicleStrategy;
    private int slotNumber = 1;
    public final VehicleType vehicleType;
    private static int ticketId = 0;
    protected List<Slot> slots;
    public VehicleManager(IParkStrategy vehicleStrategy, VehicleType vehicleType, int floorNumber, String parkingLotId) {
        this.vehicleType = vehicleType;
        this.vehicleStrategy = vehicleStrategy;
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.slots = new ArrayList<>();
    }

    public void addParkingSpace(int slotNumber) {
        addParkingSpaceToManager(slotNumber);
    }
    protected void findParkingSpace(Vehicle vehicle) {
        Slot parkingSpace = vehicleStrategy.findParkingSpace(slots, vehicleType);
        parkingSpace.setVehicle(vehicle);
    }
    public Ticket parkVehicle(Vehicle vehicle, String parkingLotId, int floorNumber) {
        Slot parkingSpace = vehicleStrategy.findParkingSpace(slots, vehicleType);
        if (parkingSpace == null) {
            return null; // No available slot
        }
        
        parkingSpace.setVehicle(vehicle);
        String ticketId = parkingLotId + "_" + floorNumber + "_" + parkingSpace.slotId;
        Ticket ticket = new Ticket(ticketId, vehicle.vehicleType, floorNumber, parkingSpace.slotId, 
                                 vehicle.vehicleNumber, vehicle.color, new Date().toString());
        return ticket;
    }

    private Slot addParkingSpaceToManager(int slotNumber) {
        Slot slot = new Slot(slotNumber, vehicleType);
        slots.add(slot);
        return slot;
    }

    public String unparkVehicle(int slotNumber) {
        // Find the slot with the given slot number
        Slot slot = null;
        for (Slot s : slots) {
            if (s.slotId == slotNumber) {
                slot = s;
                break;
            }
        }
        
        if (slot == null || !slot.isOccupied()) {
            return "Invalid Ticket";
        }
        
        Vehicle vehicle = slot.getVehicle();
        slot.removeVehicle();
        
        return "Unparked vehicle with Registration Number: " + vehicle.vehicleNumber + " and Color: " + vehicle.color;
    }
    
    // Display helper methods
    public int getFreeSlotCount() {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.isFree()) {
                count++;
            }
        }
        return count;
    }
    
    public List<Integer> getFreeSlots() {
        List<Integer> freeSlots = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot.isFree()) {
                freeSlots.add(slot.slotId);
            }
        }
        return freeSlots;
    }
    
    public List<Integer> getOccupiedSlots() {
        List<Integer> occupiedSlots = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot.isOccupied()) {
                occupiedSlots.add(slot.slotId);
            }
        }
        return occupiedSlots;
    }
}

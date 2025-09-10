package managers;
import managers.FloorManager;
import managers.strategy.IParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Ticket;
import dto.SlotConfiguration;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import managers.vehicleManager.VehicleManager;
public class ParkingLotManager {
    int numFloors;
    public List<FloorManager> floors;
    public final String parkingLotId;
    public final IParkStrategy parkStrategy;
    private Map<String, Ticket> tickets; // Centralized ticket storage
    private SlotConfiguration slotConfiguration;

    public ParkingLotManager(int numFloors, String parkingLotId, int numSlots, IParkStrategy parkStrategy) {
        this(numFloors, parkingLotId, numSlots, parkStrategy, SlotConfiguration.createDefaultConfiguration());
    }
    
    public ParkingLotManager(int numFloors, String parkingLotId, int numSlots, IParkStrategy parkStrategy, SlotConfiguration slotConfig) {
        this.numFloors = numFloors;
        this.floors = new ArrayList<>();
        this.parkingLotId = parkingLotId;
        this.parkStrategy = parkStrategy;
        this.tickets = new HashMap<>();
        this.slotConfiguration = slotConfig;
        
        for (int i = 0; i < numFloors; i++) {
            FloorManager floor = new FloorManager(i + 1, numSlots, parkingLotId, parkStrategy, slotConfig);
            // Allocate slots according to configuration
            for (int slotNum = 1; slotNum <= numSlots; slotNum++) {
                VehicleType slotType = slotConfiguration.getVehicleTypeForSlot(slotNum);
                floor.addParkingSpace(slotType, slotNum);
            }
            floors.add(floor);
        }
    }
    
    // Display methods
    public void displayFreeCount(VehicleType vehicleType) {
        for (FloorManager floor : floors) {
            int freeCount = floor.getFreeSlotCount(vehicleType);
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + floor.floorNumber + ": " + freeCount);
        }
    }
    
    public void displayFreeSlots(VehicleType vehicleType) {
        for (FloorManager floor : floors) {
            List<Integer> freeSlots = floor.getFreeSlots(vehicleType);
            String slotsString = freeSlots.isEmpty() ? "" : freeSlots.toString().replaceAll("[\\[\\]\\s]", "");
            System.out.println("Free slots for " + vehicleType + " on Floor " + floor.floorNumber + ": " + slotsString);
        }
    }
    
    public void displayOccupiedSlots(VehicleType vehicleType) {
        for (FloorManager floor : floors) {
            List<Integer> occupiedSlots = floor.getOccupiedSlots(vehicleType);
            String slotsString = occupiedSlots.isEmpty() ? "" : occupiedSlots.toString().replaceAll("[\\[\\]\\s]", "");
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + floor.floorNumber + ": " + slotsString);
        }
    }
    
    public Ticket parkVehicle(Vehicle vehicle) {
        // Find the first available slot for the vehicle type
        for (FloorManager floor : floors) {
            Ticket ticket = floor.parkVehicle(vehicle, this);
            if (ticket != null) {
                tickets.put(ticket.ticketId, ticket);
                return ticket;
            }
        }
        return null; // No available slot
    }
    
    public String unparkVehicle(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null || !ticket.isActive()) {
            return "Invalid Ticket";
        }
        
        // Get the floor and unpark the vehicle
        FloorManager floor = floors.get(ticket.floorNumber - 1);
        String result = floor.unparkVehicle(ticket.slotNumber);
        
        if (result.startsWith("Unparked")) {
            ticket.close();
        }
        
        return result;
    }

}
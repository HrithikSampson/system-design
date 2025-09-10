import managers.ParkingLotManager;
import managers.strategy.ParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Ticket;
import dto.SlotConfiguration;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static ParkingLotManager parkingLot;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String command;
        
        while (true) {
            command = scanner.nextLine().trim();
            if (command.equals("exit")) {
                break;
            }
            
            String[] parts = command.split(" ");
            if (parts.length == 0) continue;
            
            switch (parts[0]) {
                case "create_parking_lot":
                    handleCreateParkingLot(parts);
                    break;
                case "park_vehicle":
                    handleParkVehicle(parts);
                    break;
                case "unpark_vehicle":
                    handleUnparkVehicle(parts);
                    break;
                case "display":
                    handleDisplay(parts);
                    break;
                default:
                    System.out.println("Invalid command: " + parts[0]);
            }
        }
        
        scanner.close();
    }
    
    private static void handleCreateParkingLot(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Invalid command format. Expected: create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>");
            return;
        }
        
        String parkingLotId = parts[1];
        int numFloors = Integer.parseInt(parts[2]);
        int numSlotsPerFloor = Integer.parseInt(parts[3]);
        
        // Create custom slot configuration
        SlotConfiguration slotConfig = createCustomSlotConfiguration();
        
        parkingLot = new ParkingLotManager(numFloors, parkingLotId, numSlotsPerFloor, new ParkStrategy(), slotConfig);
        System.out.println("Created parking lot with " + numFloors + " floors and " + numSlotsPerFloor + " slots per floor");
    }
    
    // Method to create custom slot configuration - easily configurable from Main
    private static SlotConfiguration createCustomSlotConfiguration() {
        // Example: Define specific slot mappings
        Map<Integer, VehicleType> slotMappings = new HashMap<>();
        slotMappings.put(1, VehicleType.TRUCK);  // Slot 1 for trucks
        slotMappings.put(2, VehicleType.BIKE);   // Slot 2 for bikes
        slotMappings.put(3, VehicleType.BIKE);   // Slot 3 for bikes
        
        // Define default pattern for remaining slots
        List<VehicleType> defaultTypes = new ArrayList<>();
        defaultTypes.add(VehicleType.CAR);  // All other slots default to cars
        
        return SlotConfiguration.createCustomConfiguration(slotMappings, defaultTypes);
    }
    
    private static void handleParkVehicle(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Invalid command format. Expected: park_vehicle <vehicle_type> <reg_no> <color>");
            return;
        }
        
        if (parkingLot == null) {
            System.out.println("Parking lot not created yet");
            return;
        }
        
        VehicleType vehicleType = VehicleType.valueOf(parts[1]);
        String regNo = parts[2];
        String color = parts[3];
        
        Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        
        if (ticket != null) {
            System.out.println("Parked vehicle. Ticket ID: " + ticket.ticketId);
        } else {
            System.out.println("Parking Lot Full");
        }
    }
    
    private static void handleUnparkVehicle(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Invalid command format. Expected: unpark_vehicle <ticket_id>");
            return;
        }
        
        if (parkingLot == null) {
            System.out.println("Parking lot not created yet");
            return;
        }
        
        String ticketId = parts[1];
        String result = parkingLot.unparkVehicle(ticketId);
        System.out.println(result);
    }
    
    private static void handleDisplay(String[] parts) {
        if (parts.length != 3) {
            System.out.println("Invalid command format. Expected: display <display_type> <vehicle_type>");
            return;
        }
        
        if (parkingLot == null) {
            System.out.println("Parking lot not created yet");
            return;
        }
        
        String displayType = parts[1];
        VehicleType vehicleType = VehicleType.valueOf(parts[2]);
        
        switch (displayType) {
            case "free_count":
                parkingLot.displayFreeCount(vehicleType);
                break;
            case "free_slots":
                parkingLot.displayFreeSlots(vehicleType);
                break;
            case "occupied_slots":
                parkingLot.displayOccupiedSlots(vehicleType);
                break;
            default:
                System.out.println("Invalid display type: " + displayType);
        }
    }
}

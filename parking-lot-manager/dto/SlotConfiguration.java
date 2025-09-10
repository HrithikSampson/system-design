package dto;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SlotConfiguration {
    private Map<Integer, VehicleType> slotTypeMap;
    private List<VehicleType> defaultSlotTypes;
    
    public SlotConfiguration() {
        this.slotTypeMap = new HashMap<>();
        this.defaultSlotTypes = new ArrayList<>();
    }
    
    // Add specific slot number to vehicle type mapping
    public void addSlotType(int slotNumber, VehicleType vehicleType) {
        slotTypeMap.put(slotNumber, vehicleType);
    }
    
    // Set default slot types for slots not explicitly configured
    public void setDefaultSlotTypes(List<VehicleType> defaultTypes) {
        this.defaultSlotTypes = new ArrayList<>(defaultTypes);
    }
    
    // Get vehicle type for a specific slot number
    public VehicleType getVehicleTypeForSlot(int slotNumber) {
        // First check if slot has explicit configuration
        if (slotTypeMap.containsKey(slotNumber)) {
            return slotTypeMap.get(slotNumber);
        }
        
        // If no explicit configuration, use default pattern
        if (!defaultSlotTypes.isEmpty()) {
            // Use modulo to cycle through default types
            int index = (slotNumber - 1) % defaultSlotTypes.size();
            return defaultSlotTypes.get(index);
        }
        
        // Fallback to CAR if no configuration
        return VehicleType.CAR;
    }
    
    // Get all slots of a specific vehicle type
    public List<Integer> getSlotsForVehicleType(VehicleType vehicleType, int totalSlots) {
        List<Integer> slots = new ArrayList<>();
        for (int i = 1; i <= totalSlots; i++) {
            if (getVehicleTypeForSlot(i) == vehicleType) {
                slots.add(i);
            }
        }
        return slots;
    }
    
    // Create a default configuration: 1=Truck, 2-3=Bike, rest=Car
    public static SlotConfiguration createDefaultConfiguration() {
        SlotConfiguration config = new SlotConfiguration();
        config.addSlotType(1, VehicleType.TRUCK);
        config.addSlotType(2, VehicleType.BIKE);
        config.addSlotType(3, VehicleType.BIKE);
        
        List<VehicleType> defaultTypes = new ArrayList<>();
        defaultTypes.add(VehicleType.CAR);
        config.setDefaultSlotTypes(defaultTypes);
        
        return config;
    }
    
    // Create a custom configuration from Main
    public static SlotConfiguration createCustomConfiguration(Map<Integer, VehicleType> slotMappings, 
                                                             List<VehicleType> defaultTypes) {
        SlotConfiguration config = new SlotConfiguration();
        config.slotTypeMap.putAll(slotMappings);
        config.setDefaultSlotTypes(defaultTypes);
        return config;
    }
}

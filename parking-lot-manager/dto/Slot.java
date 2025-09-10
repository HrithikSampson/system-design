package dto;
import dto.VehicleType;
public class Slot {
    public final int slotId;
    public final VehicleType vehicleType;
    private Vehicle vehicle;
    public Slot(int slotId, VehicleType vehicleType) {
        this.slotId = slotId;
        this.vehicleType = vehicleType;
        vehicle = null;
    }
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
    public void setVehicle(Vehicle vehicle) {
        if(isOccupied()) {
            throw new IllegalArgumentException("Slot already has a vehicle");
        }
        if(this.vehicleType != vehicle.vehicleType) {
            throw new IllegalArgumentException("Vehicle type does not match slot type");
        }
        this.vehicle = vehicle;
    }
    
    public void removeVehicle() {
        this.vehicle = null;
    }
    
    public boolean isOccupied() {
        return vehicle != null;
    }
    
    public boolean isFree() {
        return vehicle == null;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
}

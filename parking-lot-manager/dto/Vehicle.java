package dto;
import dto.VehicleType;
public class Vehicle {
    public final VehicleType vehicleType;
    public final String vehicleNumber;
    public final String color;
    public Vehicle(VehicleType vehicleType, String vehicleNumber, String color) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
    }
    public String toString() {
        return "Vehicle [vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + ", color=" + color + "]";
    }
}

package dto;

import dto.VehicleType;

public class Ticket {
    public final String ticketId;
    public final VehicleType vehicleType;
    public final int floorNumber;
    public final int slotNumber;
    public final String vehicleId;
    public final String color;
    public final String issuedAt;
    public String closedAt;

    public Ticket(String ticketId, VehicleType vehicleType, int floorNumber, int slotNumber, 
                  String vehicleId, String color, String issuedAt) {
        this.ticketId = ticketId;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.vehicleId = vehicleId;
        this.color = color;
        this.issuedAt = issuedAt;
        this.closedAt = null;
    }

    public void close() {
        this.closedAt = new java.util.Date().toString();
    }

    public boolean isActive() {
        return this.closedAt == null;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleType=" + vehicleType +
                ", floorNumber=" + floorNumber +
                ", slotNumber=" + slotNumber +
                ", vehicleId='" + vehicleId + '\'' +
                ", color='" + color + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                ", closedAt='" + closedAt + '\'' +
                '}';
    }
}

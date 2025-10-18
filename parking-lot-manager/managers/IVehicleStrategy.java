package managers;
import dto.Slot;
import java.util.List;
public interface IVehicleStrategy {
    Slot findParkingSpace(List<Slot> slots, VehicleType vehicleType);
}

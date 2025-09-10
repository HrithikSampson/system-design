package managers.strategy;
import dto.Slot;
import dto.VehicleType;
import java.util.List;
public interface IParkStrategy {
    Slot findParkingSpace(List<Slot> slots, VehicleType vehicleType);
}

package managers.strategy;
import dto.Slot;
import dto.VehicleType;
import java.util.List;
public class ParkStrategy implements IParkStrategy {
    @Override
    public Slot findParkingSpace(List<Slot> slots, VehicleType vehicleType) {
        for(Slot slot : slots) {
            if(slot.getVehicleType() == vehicleType && slot.isFree()) {
                return slot;
            }
        }
        return null;
    }
}

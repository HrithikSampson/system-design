package managers.vehicleManager;
import managers.strategy.IParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Slot;
import java.util.Date;
import java.util.List;
public class TruckManager extends VehicleManager {
    public TruckManager(IParkStrategy truckStrategy, VehicleType vehicleType, int floorNumber, String parkingLotId) {
        super(truckStrategy, vehicleType, floorNumber, parkingLotId);
    }
}
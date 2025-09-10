package managers.vehicleManager;
import managers.strategy.IParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Slot;
import java.util.Date;
import java.util.List;
public class BikeManager extends VehicleManager {
    public BikeManager(IParkStrategy bikeStrategy, VehicleType vehicleType, int floorNumber, String parkingLotId) {
        super(bikeStrategy, vehicleType, floorNumber, parkingLotId);
    }
}
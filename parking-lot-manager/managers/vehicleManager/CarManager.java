package managers.vehicleManager;
import managers.strategy.IParkStrategy;
import dto.VehicleType;
import dto.Vehicle;
import dto.Slot;
import java.util.Date;
import java.util.List;
public class CarManager extends VehicleManager {
    public CarManager(IParkStrategy carStrategy, VehicleType vehicleType, int floorNumber, String parkingLotId) {
        super(carStrategy, vehicleType, floorNumber, parkingLotId);
    }
}
package managers;
import managers.vehicleManager.VehicleManager;
import managers.vehicleManager.TruckManager;
import managers.vehicleManager.CarManager;
import managers.vehicleManager.BikeManager;
import managers.strategy.IParkStrategy;
import managers.strategy.ParkStrategy;
import dto.VehicleType;
import java.util.Map;
import java.util.HashMap;

public class VehicleManagerFactory {
    private Map<VehicleType, VehicleManager> vehicleManagerMap;
    private int floorNumber;
    private String parkingLotId;
    
    public VehicleManagerFactory(int floorNumber, String parkingLotId) {
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.vehicleManagerMap = new HashMap<>();
    }
    public VehicleManager getVehicleManager(VehicleType vehicleType) {
        if (!vehicleManagerMap.containsKey(vehicleType)) {
            vehicleManagerMap.put(vehicleType, getVehicleManagerType(vehicleType));
        }
        return vehicleManagerMap.get(vehicleType);
    }
    
    private VehicleManager getVehicleManagerType(VehicleType vehicleType) {
        IParkStrategy strategy = new ParkStrategy();
        switch (vehicleType) {
            case TRUCK:
                return new TruckManager(strategy, vehicleType, floorNumber, parkingLotId);
            case CAR:
                return new CarManager(strategy, vehicleType, floorNumber, parkingLotId);
            case BIKE:
                return new BikeManager(strategy, vehicleType, floorNumber, parkingLotId);
            default:
                return null;
        }
    }
}

package engine.strategies;

public class OffRoadDrive implements IDriveStrategy {
    @Override
    public void startEngine() {
        System.out.println("Starting off-road engine");
    }
}

package engine.strategies;

public class SuperEngine implements IDriveStrategy {
    @Override
    public void startEngine() {
        System.out.println("Starting super engine");
    }
}

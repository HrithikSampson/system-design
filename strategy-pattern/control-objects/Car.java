package control.objects;

import engine.strategies.IDriveStrategy;

public abstract class Car {
    private IDriveStrategy engineStrategy;

    public Car(IDriveStrategy engineStrategy) {
        this.engineStrategy = engineStrategy;
    }

    public void drive() {
        engineStrategy.startEngine();
    }
}

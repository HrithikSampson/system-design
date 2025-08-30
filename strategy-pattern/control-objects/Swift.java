package control.objects;

import engine.strategies.OffRoadDrive;

public class Swift extends Car {
    public Swift() {
        super(new OffRoadDrive());
    }
}

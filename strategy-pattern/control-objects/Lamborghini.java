package control.objects;

import engine.strategies.SuperEngine;

public class Lamborghini extends Car {
    public Lamborghini() {
        super(new SuperEngine());
    }
}

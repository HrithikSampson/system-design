package control.objects;

import engine.strategies.SuperEngine;

public class Ferrari extends Car {
    public Ferrari() {
        super(new SuperEngine());
    }
}

package control.objects;

import java.util.List;
import java.util.ArrayList;
import control.objects.IStockObservable;
import control.objects.IStockObservor;

public class StockCurrencyObservable implements IStockObservable {
    private String symbol;
    private double price;
    private List<IStockObservor> observers;

    public StockCurrencyObservable(String symbol) {
        this.symbol = symbol;
        this.observers = new ArrayList<>();
    }

    public void addObserver(IStockObservor observer) {
        observers.add(observer);
    }

    public void removeObserver(IStockObservor observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IStockObservor observer : observers) {
            observer.update(this);
        }
    }
    
    
    @Override
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
    
    
}

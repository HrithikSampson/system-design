package control.objects;

import control.objects.IStockObservable;
import control.objects.IStockObservor;

public class StockObservor implements IStockObservor {
    
    @Override
    public void update(IStockObservable stock) {
        System.out.println("Stock price updated: " + stock.getPrice() + " " + stock.getSymbol());
    }

}

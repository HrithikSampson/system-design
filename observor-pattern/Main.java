import control.objects.StockFactory;
import control.objects.IStockObservable;
import control.objects.StockObservor;

public class Main {
    public static void main(String[] args) {
        StockFactory stockFactory = new StockFactory();
        IStockObservable stock = stockFactory.getStock("AAPL");
        stock.addObserver(new StockObservor());
        stock.setPrice(100);

    }
}

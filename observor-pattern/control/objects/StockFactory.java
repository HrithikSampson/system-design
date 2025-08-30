package control.objects;

import java.util.HashMap;
import java.util.Map;
import control.objects.IStockObservable;
import control.objects.StockCurrencyObservable;

public class StockFactory {
    private Map<String, IStockObservable> stocks;

    public StockFactory() {
        this.stocks = new HashMap<>();
    }
    
    
    public IStockObservable getStock(String symbol) {
        if (stocks.containsKey(symbol)) {
            return stocks.get(symbol);
        }
        IStockObservable stock = new StockCurrencyObservable(symbol);
        stocks.put(symbol, stock);
        return stock;
    }
}

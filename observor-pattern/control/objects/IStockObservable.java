package control.objects;
import control.objects.IStockObservor;

public interface IStockObservable {
    void addObserver(IStockObservor observer);
    void removeObserver(IStockObservor observer);
    double getPrice();
    String getSymbol();
    void setPrice(double price);
}

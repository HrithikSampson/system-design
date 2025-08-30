import control.objects.Car;
import control.objects.Swift;
import control.objects.Ferrari;
import control.objects.Lamborghini;

public class Main {
    public static void main(String[] args) {
        Car swift = new Swift();
        swift.drive();

        Car ferrari = new Ferrari();
        ferrari.drive();

        Car lamborghini = new Lamborghini();
        lamborghini.drive();
    }
}

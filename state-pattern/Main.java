import control.objects.Context;
import control.objects.InitState;
import control.objects.FinalState;
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new InitState());
        context.request();

        context.setState(new FinalState());
        context.request();
    }
}
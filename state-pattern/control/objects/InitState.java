package control.objects;

public class InitState implements State {
    @Override
    public void handle() {
        System.out.println("Handling Init State");
    }
    
}

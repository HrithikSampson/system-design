package control.objects;
public class FinalState implements State {
    @Override
    public void handle() {
        System.out.println("Handling Final State");
    }
    
}

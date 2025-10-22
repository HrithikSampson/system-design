
public abstract class Button {
    protected boolean isPressed;
    protected ButtonCommand command;

    public Button(ButtonCommand command) {
        this.isPressed = false;
        this.command = command;
    }

    public abstract void press();
    
    public abstract void submitRequest();
}
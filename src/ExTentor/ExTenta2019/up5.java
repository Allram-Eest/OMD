package ExTentor.ExTenta2019;

public class up5 {
    public static void main(String[] args) {
        SolidPlayer OMDPlayer = new SolidPlayer(OmdMp3Circuit);
        OMDPlayer.addButton(new Mp3Button("Volume Up", OmdMp3Circuit, (circuit) -> circuit.changeVolume(10)));
        OMDPlayer.addButton(new Mp3Button("Volume Down", OmdMp3Circuit, (circuit) -> circuit.changeVolume(-10)));
    }
}

class Button {
    public Button(String label) {

    }
    public void addButtonPressHandler(ButtonPressHandler s) {

    }
}

interface ButtonEvent {
    Button source(); // anger vilken knapp som tryckts
    Instant timeStamp(); // anger tidpunkten
}

interface Instant {

}

interface ButtonPressHandler {
    void handleButtonPress(ButtonEvent event); // anropas vid tryck på knappen
}

class Gui {
    public void add(Button button) {} // lägger in en knapp i GUI: t
}

interface Mp3Circuit {
    void togglePlay(); // startar eller pausar uppspelning
    void skip(int step); // hoppar bland spåren, negativa värden hoppar bakåt
    void changeVolume(int percent); // ändrar volymen, negativa värden sänker den
}

class SolidPlayer extends Gui{
    private Mp3Circuit circuit;

    public SolidPlayer(Mp3Circuit circuit) {
        this.circuit = circuit;
    }

    public void addButton(Mp3Button button) {
        add(button.getButton());
    }
}



class Mp3Button implements ButtonPressHandler{
    private Mp3Circuit circuit;
    private Button button;
    private Mp3ButtonHandler handler;

    public Mp3Button(String label, Mp3Circuit circuit, Mp3ButtonHandler handler) {
        this.circuit = circuit;
        this.button = new Button(label);
        this.handler = handler;
        button.addButtonPressHandler(this);
    }

    public Button getButton() {
        return button;
    }

    @Override
    public void handleButtonPress(ButtonEvent event) {
        handler.action(circuit);
    }
}

interface Mp3ButtonHandler {
    public void action(Mp3Circuit circuit);
}
package Sem3;

import javax.swing.*;

import java.util.*;

class Switch extends JButton implements ActionListener {

    private boolean on = false;

    public Switch() {
        super("OFF");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        on = !on;
        setText(on ? "ON" : "OFF");
    }
}

class SwitchModel extends Observable { //Vår modell

    private boolean on;

    public SwitchModel () {} //Tom metod, dvs okej att skriva på samma rad

    public boolean isOn() {
        return on;
    }

    public void toggle() {
        on = !on;
    }
}

class SwitchView extends JButton { //Vår vy

    private SwitchModel model; //View beror på modellen

    public SwitchView (SwitchModel model) {
        super("Pending...");
        this.model = model;
        update();
    }

    public void update() {
        setText(model.isOn() ? "On" : "Off");
    }
}

class SwitchController { //Vår controller. När vi skapar en controller kommer vi aldrig kalla en metod på den. Den bara sitter där och är gullig. 

    // public SwitchController(SwitchModel model, SwitchView view) {
    //     view.addActionListener(e -> {
    //             model.toggle();
    //             view.update();
    //         });
    // }

    public SwitchController(SwitchModel model, SwitchView view) {
        model.addObserver((obs, obj) -> view.update());
        view.addActionListener(e -> model.toggle());
    }    
}
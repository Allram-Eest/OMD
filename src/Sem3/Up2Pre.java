package Sem3;

import javax.swing.*;

class Switch extends JButton {
    private boolean on = false;

    public Switch() {
        super("OFF");
        addActionListener(new ButtonListener());
    }
}

class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

    }
}


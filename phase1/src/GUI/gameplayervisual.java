package GUI;

import javax.swing.*;
import java.awt.*;

public class gameplayervisual extends JPanel {

    private int xpos;

    private int ypos;

    public gameplayervisual(int xpos, int ypos){
        this.setBounds(xpos, ypos, 25, 15);
        this.setBackground(new Color(129, 50, 168));

    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos){
        this.ypos = ypos;
    }
}
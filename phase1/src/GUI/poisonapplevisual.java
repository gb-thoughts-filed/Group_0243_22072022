package GUI;

import javax.swing.*;
import java.awt.*;


public class poisonapplevisual extends JPanel {


    private int xpos;

    private int ypos;

    public poisonapplevisual(int xpos, int ypos){
        this.setBounds(xpos, ypos, 10, 10);
        this.setBackground(Color.BLACK);

    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }
}



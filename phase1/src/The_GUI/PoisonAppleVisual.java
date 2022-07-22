package The_GUI;

import javax.swing.*;
import java.awt.*;


public class PoisonAppleVisual extends JPanel {


    private int xpos;

    private int ypos;

    public PoisonAppleVisual(int xpos, int ypos){
        this.setBounds(xpos, ypos, 10, 10);
        this.setBackground(Color.BLACK);

    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getXpos(){
        return this.xpos;
    }
}



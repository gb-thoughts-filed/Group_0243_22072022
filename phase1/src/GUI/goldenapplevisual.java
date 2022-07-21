package GUI;

import javax.swing.*;
import java.awt.*;

public class goldenapplevisual extends JPanel {

    private int xpos;

    private int ypos;

    public goldenapplevisual(int xpos, int ypos){
        this.setBounds(xpos, ypos, 10, 10);
        this.setBackground(new Color(212, 175, 55));

    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getXpos(){
        return this.xpos;
    }
}


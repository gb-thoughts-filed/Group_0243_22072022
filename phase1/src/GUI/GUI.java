package GUI;

import javax.swing.*;

public class GUI {

    //source to help make initial GUI.GUI frame
    public GUI() {
        JFrame window  = new JFrame("Not Flappy Bird");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setSize(300, 600);

        gameboard_canvas canvas = new gameboard_canvas();

        window.add(canvas);

        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.pack();
        window.setVisible(true);

    }

   // public drawBoard(){



    }



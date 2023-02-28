package org.example;

import javax.swing.*;
import java.awt.*;


/**
 * Window that the game of the Pong is running in.
 */
public class MainFrame {
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGHT = 500;

    private final JFrame window = new JFrame("Pong");
    private final JPanel statusPanel = new JPanel();


    public MainFrame(){
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setResizable(false);

        setupStatusPanel();

        //TODO: add components



        window.setVisible(true);
    }



    /**
     * Adds all necessary components to the status panel.
     */
    private void setupStatusPanel(){
        //TODO: add things to the status panel

        window.add(statusPanel, BorderLayout.NORTH);
    }
}

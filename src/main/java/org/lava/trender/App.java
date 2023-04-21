package org.lava.trender;

import javax.swing.JFrame;

public class App {
    public static void main( String[] args ) {
        JFrame frame = new JFrame();
        frame.setTitle("Lava Project");
        frame.setResizable(false);
        Placeholder game = new Placeholder();
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setVisible(true);

        game.start();
    }
}

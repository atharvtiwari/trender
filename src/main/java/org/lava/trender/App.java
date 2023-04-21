package org.lava.trender;

import javax.swing.JFrame;

import org.lava.trender.controller.Renderer;

public class App {
    public static void main( String[] args ) {
        JFrame frame = new JFrame();
        frame.setTitle("Lava Project");
        frame.setResizable(false);
        Renderer game = new Renderer();
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setVisible(true);

        game.start();
    }
}

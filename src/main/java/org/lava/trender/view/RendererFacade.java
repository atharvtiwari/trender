package org.lava.trender.view;

import javax.swing.JFrame;

public class RendererFacade {
    private Renderer renderer;

    public RendererFacade() {
        JFrame frame = new JFrame();
        frame.setTitle("Lava Project");
        frame.setResizable(false);
        renderer = new Renderer();
        frame.add(renderer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    public void start() {
        renderer.start();
    }

    public void stop() {
        renderer.stop();
    }
}


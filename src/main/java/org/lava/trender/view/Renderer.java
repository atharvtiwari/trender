package org.lava.trender.view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import org.lava.trender.controller.Game;
import org.lava.trender.controller.InputHandler;
import org.lava.trender.model.Screen;

public class Renderer extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH  * 3 / 4;
    public static final int SCALE = 4;
    public static final double FRAME_RATE = 60.0;

    private boolean isRunning = false;

    public final BufferedImage image;
    public final int[] pixels;

    private Game game;
    private Screen screen;
    private InputHandler inputHandler;

    public Renderer() {
        Dimension dimension= new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addFocusListener(inputHandler);
    }
    public void start() {
        if (isRunning)
            return;
        isRunning = true;

        init();
        new Thread(this).start();
    }

    public void init() {
        game = new Game();
        screen = new Screen(WIDTH, HEIGHT);
    }

    public void run() {
        final double nsPerUpdate = 1000000000 / FRAME_RATE;

        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        // long frameCounter = System.currentTimeMillis();

        while(isRunning) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - lastTime;
            lastTime = currentTime;
            unprocessedTime += passedTime;

            if (unprocessedTime >= nsPerUpdate) {
                unprocessedTime = 0;
                update();
            }
            render();
        }
        dispose();
    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        for (int i =0; i< pixels.length; i++)
            pixels[i] = 0;
        
        screen.render(game);

        for (int i = 0; i < pixels.length; ++i)
            pixels[i] = screen.pixels[i];
        
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        g.dispose();
        bs.show();
    }

    public void update() {
        game.update(inputHandler.keys);
    }
    
    public void stop() {
        if (!isRunning)
            return;
        isRunning = false;
    }

    public void dispose() {
        System.exit(0);
    }
}

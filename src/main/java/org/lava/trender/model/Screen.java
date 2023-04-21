package org.lava.trender.model;

import java.util.Random;

import org.lava.trender.controller.Game;

public class Screen extends Bitmap {
    public Random r= new Random();
    public Bitmap test;
    public Bitmap3D perspectiveVision;

    public Screen(int width, int height) {
        super(width, height);

        test = new Bitmap(50, 50);
        for (int i =0; i<test.pixels.length; i++) {
            test.pixels[i] = r.nextInt();
        }

        perspectiveVision = new Bitmap3D(width, height);
    }
    
    public void render(Game game) {
        clear();
        perspectiveVision.render(game);
        perspectiveVision.renderFog(3);
        render(perspectiveVision, 0, 0);
    }
    
}

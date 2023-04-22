package org.lava.trender.model;

import org.lava.trender.controller.Game;

public class Screen extends Bitmap {
    private Bitmap3D perspectiveVision;

    public Screen(int width, int height) {
        super(width, height);

        perspectiveVision = new BitmapFactory().createBitmap3D(width, height);
    }
    
    public void render(Game game) {
        clear();
        perspectiveVision.render(game);
        perspectiveVision.renderFog(3);
        render(perspectiveVision, 0, 0);
    }
}

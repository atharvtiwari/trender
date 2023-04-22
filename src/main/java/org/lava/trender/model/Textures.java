package org.lava.trender.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
    public static Bitmap textures = loadTexture("/textures/textures.png");

    public static Bitmap loadTexture(String path) {
        try {
            BufferedImage image = ImageIO.read(Textures.class.getResourceAsStream(path));
            Bitmap res = new BitmapFactory().createBitmap(image.getWidth(), image.getHeight());
            int resWidth = res.getWidth();
            int resHeight = res.getHeight();
            int[] resPixels = res.getPixels();
            image.getRGB(0, 0, resWidth, resHeight, resPixels, 0, resWidth);

            for (int i = 0; i < resPixels.length; ++i) {
                int ci = resPixels[i];
                int col = (ci & 0xf) >> 2;
                if (ci == 0xffff00ff)
                    col = -1;
                res.setPixel(col, i);
            }

            return res;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}

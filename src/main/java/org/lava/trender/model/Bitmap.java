package org.lava.trender.model;

public class Bitmap
{
    private int width;
    private int height;
    private int[] pixels;
    
    public Bitmap(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[] getPixels()
    {
        return pixels;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setPixel(int value, int position)
    {
        this.pixels[position] = value;
    }

    public void render(Bitmap bitmap, int ox, int oy)
    {
        for (int y = 0; y < bitmap.height; y++)
        {
            int yy = y + oy;
            if (yy < 0 || yy >= height)
                continue;
            
            for (int x = 0; x < bitmap.width; x++)
            {
                int xx = x + ox;
                if (xx < 0 || xx >= width)
                    continue;
                int alpha = bitmap.pixels[x + (y * bitmap.width)];
                if (alpha > 0)
                {
                    pixels[xx + (yy * width)] = alpha;
                }
            }
        }
    }

    public void clear()
    {
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = 0;
        }
    }
}

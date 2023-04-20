package org.lava.trender.model;

public class Bitmap
{
    public int width;
    public int height;
    public int[] pixels;
    
    public Bitmap(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height]; 
    }

    public void render(Bitmap bitmap, int ox, int oy)
    {
        for (int y = 0; y < bitmap.height; y++)
        {
            int yy = y + oy;
            if (yy < 0 || yy >= height)
            {
                continue;
            }
            else
            {
                for (int x = 0; x < bitmap.width; x++)
                {
                    int xx = x + ox;
                    if (xx < 0 || xx >= width)
                    {
                        continue;
                    }
                    else
                    {
                        int alpha = bitmap.pixels[x + (y * bitmap.width)];
                        if (alpha > 0)
                        {
                            pixels[xx + (yy * width)] = alpha;
                        }
                    }
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
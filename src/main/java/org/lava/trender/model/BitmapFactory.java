package org.lava.trender.model;

public class BitmapFactory
{
    public Bitmap createBitmap(int width, int height)
    {
        return new Bitmap(width, height);
    }

    public Bitmap createBitmap3D(int width, int height)
    {
        return new Bitmap3D(width, height);
    }

    public Bitmap createScreen(int width, int height)
    {
        return new Screen(width, height);
    }
}
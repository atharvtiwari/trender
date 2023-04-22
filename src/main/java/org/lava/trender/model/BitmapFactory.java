package org.lava.trender.model;

public class BitmapFactory
{
    public Bitmap createBitmap(int width, int height)
    {
        return new Bitmap(width, height);
    }

    public Bitmap3D createBitmap3D(int width, int height)
    {
        return new Bitmap3D(width, height);
    }

    public Screen createScreen(int width, int height)
    {
        return new Screen(width, height);
    }
}
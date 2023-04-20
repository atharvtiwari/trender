package org.lava.trender.model;

public class Sprite
{
    public final double x, y, z;
    public int texture = 0;
    public int colour = 0x444444;

    public Sprite(double x, double y, double z, int texture, int colour)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.texture = texture;
        this.colour = colour;
    }
}
package org.lava.trender.model;

public class Sprite
{
    private final double x, y, z;
    private int texture;
    private int colour;

    private Sprite(SpriteBuilder builder)
    {
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.texture = builder.texture;
        this.colour = builder.colour;
    }

    public static class SpriteBuilder
    {
        private double x = 0;
        private double y = 0;
        private double z = 0;
        private int texture = 0;
        private int colour = 0x444444;

        public SpriteBuilder setX(double x) {
            this.x = x;
            return this;
        }

        public SpriteBuilder setY(double y) {
            this.y = y;
            return this;
        }

        public SpriteBuilder setZ(double z) {
            this.z = z;
            return this;
        }

        public SpriteBuilder setTexture(int texture) {
            this.texture = texture;
            return this;
        }

        public SpriteBuilder setColour(int colour) {
            this.colour = colour;
            return this;
        }

        public Sprite build() {
            return new Sprite(this);
        }
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
    
    public double getZ()
    {
        return z;
    }

    public int getTexture()
    {
        return texture;
    }

    public int getColour()
    {
        return colour;
    }
}